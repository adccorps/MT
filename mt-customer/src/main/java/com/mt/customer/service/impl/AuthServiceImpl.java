package com.mt.customer.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.customer.pojo.LoginCustomerDTO;
import com.mt.customer.utils.Encryption;
import com.mt.customer.utils.jwtUtils;
import com.mt.pojo.Customer;
import com.mt.pojo.Messages;
import com.mt.pojo.Result;
import com.mt.redis.RedisUtils;
import com.mt.customer.dao.CustomerDao;
import com.mt.customer.dao.PermissionDao;
import com.mt.customer.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    PermissionDao permissionDao;
    @Autowired
    RabbitTemplate  rabbitTemplate;
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
        if (redisUtils.exists(customerName)) {
            String jwt = (String) redisUtils.hget(customerName,"token");
            //3. 验证token是否正确
            return jwt.equals(token);
        }
        return false;
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
                if (!adminSet.contains(serverName) || !adminSet.contains(checkUrl)) {
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
    public Object login(Customer customer) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(customer.customerName, customer.password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return  null;
        }
        customer= (Customer) subject.getPrincipal();
        String jwt = jwtUtils.getToken(customer);
        /*将token 存入reids实现服务共享*/
        redisUtils.hset(customer.customerName, "token",jwt);
        redisUtils.hset(customer.customerName,"id" ,customer.customerId);

        LoginCustomerDTO customerDTO = new LoginCustomerDTO(customer,jwt);
        return customerDTO;
    }

    @Override
    public Object loginByPhone(String phone,String s) {
      Messages messages = (Messages) redisUtils.get(phone);
        Object result = Encryption.md5Encryption(messages.getCode(), messages.getPhone());
        if (result.toString().equals(s)) {
            Customer customer = customerDao.getCustomerByPhone(phone);
            //加密,获取token
            String jwt = jwtUtils.getToken(customer);
            /*将token 存入reids实现服务共享*/
            redisUtils.hset(customer.customerName, "token",jwt);
            redisUtils.hset(customer.customerName,"id" ,customer.customerId);
            LoginCustomerDTO customerDTO = new LoginCustomerDTO(customer,jwt);
            return customerDTO;
        }
        //验证码登录失败处理
        return new Result().put("msg","验证失败");
    }


    /**
     * 获取yml的白名单set
     */
    @Value("${sadminSet}")
    public void setSadminSet(Set<String> sadminSet) {
        this.sadminSet = sadminSet;
    }

    @Value("${adminSet}")
    public void setAdminSet(Set<String> adminSet) {
        this.adminSet = adminSet;
    }
}
