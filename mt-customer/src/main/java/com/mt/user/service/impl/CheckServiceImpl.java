package com.mt.user.service.impl;

import com.mt.redis.RedisUtils;
import com.mt.user.dao.CustomerDao;
import com.mt.user.dao.PermissionDao;
import com.mt.user.pojo.Customer;
import com.mt.user.service.CheckService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    PermissionDao permissionDao;

    /**
     * 检查是否已经登录
     */
    @Override
    public boolean isLogin(String token) {
        // 1.解析token 获取id
        String customerId = null;
        // 2.通过id到redis查询token
        String jwt;
        redisUtils.get(customerId);
        //3. 验证token是否正确
        return false;
    }

    /**
     * 检查当前路径是否有权限请求
     */

    @Override
    public boolean checkPermission(String token, String checkUrl) {
        // 1.获取用户权限信息
        // 2.扫描文件url
        // 判断权限是否能够访问
        return false;
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
        /*将token 存入reids实现服务共享*/
        redisUtils.set(customer.customerName, token);
        return token.toString();
    }
}
