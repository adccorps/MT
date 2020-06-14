package com.mt.customer.service.impl;

import com.auth0.jwt.JWT;

import com.mt.constants.Code;
import com.mt.customer.pojo.LoginCustomerDTO;

import com.mt.customer.utils.Encryption;
import com.mt.customer.utils.jwtUtils;
import com.mt.exception.ResultException;
import com.mt.pojo.Customer;
import com.mt.pojo.Messages;

import com.mt.redis.RedisUtils;
import com.mt.customer.dao.CustomerDao;
import com.mt.customer.dao.PermissionDao;
import com.mt.customer.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.apache.shiro.util.ByteSource;
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

    // 权限白名单
    private static Set<String> adminSet;
    private static Set<String> userSet;

    /**
     * 检查是否已经登录,校验token
     *
     * @return
     */
    @Override
    public boolean isLogin(String token) {
        if (token == null || token.equals("")) {
            throw new ResultException(Code.UNAUTHORIZED);
        }
        // 1.解析token 获取id
        String customerName = JWT.decode(token).getClaim("customerName").asString();
//        String customerName = customerDao.getCustomerById(id).getCustomerName();
        // 2.通过id到redis查询token
        if (redisUtils.exists(customerName)) {
            String jwt = (String) redisUtils.hget(customerName, "token");
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
        if (token == null || token.equals("")) {
            throw new ResultException(Code.UNAUTHORIZED);
        }
        // 1.获取用户权限信息
        String customerId = JWT.decode(token).getClaim("id").asString();
        int permissionId = customerDao.getCustomerById(customerId).getPermissionId();
        String serverName = StringUtils.substringBetween(checkUrl, "/", "/");
        System.out.println(permissionId);
        switch (permissionId) {
            case 1:
                return true;
            case 2:
                if (adminSet.contains(serverName) || adminSet.contains(checkUrl)) {
                    System.out.println("admin权限进入");
                    return true;
                }
                break;
            default:
                if (userSet.contains(serverName) || userSet.contains(checkUrl)) {
                    System.out.println("用户权限进入");
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 登录,并且存储到redis
     * 应该返回token给前端
     */
    @Override
    public Object login(Customer customer) {
        Subject subject = SecurityUtils.getSubject();
        //获取id
        Customer temp= customerDao.getCustomerByName(customer.customerName);
        ByteSource salt = ByteSource.Util.bytes(temp.customerId);
        Object pass=  Encryption.md5Encryption(customer.password,salt);
        UsernamePasswordToken token = new UsernamePasswordToken(customer.customerName, pass.toString());
        subject.login(token);
        customer = (Customer) subject.getPrincipal();
        String jwt = jwtUtils.getToken(customer);
        /*将token 存入reids实现服务共享*/
        redisUtils.hset(customer.customerName, "token", jwt);
        redisUtils.hset(customer.customerName, "id", customer.customerId);

        LoginCustomerDTO customerDTO = new LoginCustomerDTO(customer, jwt);
        return customerDTO;
    }

    @Override
    public Object loginByPhone(String phone, String verifiedCode) {
        Customer customer = customerDao.getCustomerByPhone(phone);
        if (customer==null) throw  new ResultException(Code.NOT_FOUND);
        //短信未放到redis,throw?
        String code = (String) redisUtils.hget(phone,"code");
        Object result = Encryption.md5Encryption(code, phone);
        if (result.toString().equals(verifiedCode)) {

            //加密,获取token
            String jwt = jwtUtils.getToken(customer);
            /*将token 存入reids实现服务共享*/
            redisUtils.hset(customer.customerName, "token", jwt);
            redisUtils.hset(customer.customerName, "id", customer.customerId);
            LoginCustomerDTO customerDTO = new LoginCustomerDTO(customer, jwt);
            return customerDTO;
        } else
            //验证码登录失败处理
            throw new ResultException(Code.UNAUTHORIZED);
    }

    @Override
    public boolean logout(String token) {
        String customerName = JWT.decode(token).getClaim("customerName").asString();
        if (redisUtils.exists(customerName)) {
            redisUtils.remove(customerName);
            return true;
        }
        return false;
    }


    /**
     * 获取yml的白名单set
     */

    @Value("${adminSet}")
    public void setAdminSet(Set<String> adminSet) {
        this.adminSet = adminSet;
    }

    @Value("${userSet}")
    public void setUserSet(Set<String> userSet) {
        this.userSet = userSet;
    }
}
