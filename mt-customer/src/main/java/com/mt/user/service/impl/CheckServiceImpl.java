package com.mt.user.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.pojo.Customer;
import com.mt.redis.RedisUtils;
import com.mt.user.controller.CustomerController;
import com.mt.user.dao.CustomerDao;
import com.mt.user.dao.PermissionDao;
import com.mt.user.service.CheckService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    PermissionDao permissionDao;

    // 权限白名单
    private static Set<String> sadminSet;
    private static Set<String> adminSet;

    /**
     * 检查是否已经登录,校验token
     *
     * @return
     */
    @Override
    public boolean isLogin(String token) {
        // 1.解析token 获取id
        String customerName = JWT.decode(token).getClaim("customerName").asString();
        // 2.通过id到redis查询token
        String jwt = (String) redisUtils.get(customerName);
        //3. 验证token是否正确
        return jwt.equals(token);
    }

    /**
     * 检查当前路径是否有权限请求
     */
    @Override
    public boolean checkPermission(String token, String checkUrl) {
        // 1.获取用户权限信息
        String permission = JWT.decode(token).getClaim("permission").asString();
        String serverName = StringUtils.substringBetween(checkUrl, "/", "/");
        switch (permission) {
            case "Sadmin":
                if (!sadminSet.contains(serverName) || !sadminSet.contains(checkUrl)) {
//                    System.out.println("Sadmin权限无法进入");
                    return false;
                }
            case "admin":
                if ( !adminSet.contains(serverName) || !adminSet.contains(checkUrl) ) {
//                    System.out.println("admin权限无法进入");
                    return false;
                }
        }
        return true;
    }

    /**
     * 登录,并且存储到redis
     * 应该返回token给前端
     */
    @Override
    public String login(Customer customer) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(customer.customerName, customer.password);
        subject.login(token);
        //查找权限
          String permission= permissionDao.getPermissionByCustomer(customer);
//        String permission = "Sadmin";
        //加密
        String jwt = JWT.create().withClaim("customerName", customer.getCustomerName())
                .withClaim("permission", permission)
                .sign(Algorithm.HMAC256(customer.getPassword()));
        /*将token 存入reids实现服务共享*/
        redisUtils.set(customer.customerName, jwt);
        return jwt;
    }

    /**
     * 获取yml的白名单set
     * */
    @Value("${sadminSet}")
    public void setSadminSet(Set<String> sadminSet) {
        this.sadminSet = sadminSet;
    }
    @Value("${adminSet}")
    public void setAdminSet(Set<String> adminSet) {
        this.adminSet = adminSet;
    }
}
