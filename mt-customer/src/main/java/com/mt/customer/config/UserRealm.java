package com.mt.customer.config;

import com.mt.constants.Code;
import com.mt.customer.service.CustomerService;
import com.mt.exception.ResultException;
import com.mt.pojo.Customer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    CustomerService customerService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();
        //拿到当前登录对象,然后在用info里设置此对象的权限
        //  Object user = subject.getPrincipal();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Customer customer=customerService.getCustomerByName(token.getUsername());
        System.out.println(customer.toString());
        System.out.println(token.getUsername()+"===="+customer.customerName);
        if (!token.getUsername().equals(customer.customerName)){
            throw new ResultException(Code.UNAUTHORIZED);
        }
        ByteSource salt = ByteSource.Util.bytes(customer.customerId);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(customer, customer.password, salt,getName());
        return info;
    }
}

