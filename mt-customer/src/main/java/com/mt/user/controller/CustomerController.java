package com.mt.user.controller;

import com.mt.user.pojo.Customer;
import com.mt.user.service.CheckService;
import com.mt.user.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户权限登录服务")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CheckService checkService;

    @PostMapping("/login/{user}/{pass}")
    @ApiOperation(value = "登录接口")
    public String login(@PathVariable("user") String user, @PathVariable("pass") String pass) {
        Customer customer = new Customer();
        customer.setCustomerName(user);
        customer.setPassword(pass);
        System.out.println(checkService.login(customer));
        return checkService.login(customer);
    }

    @GetMapping("/auth/login")
    @ApiOperation(value = "登录检测接口")
    public boolean checkLogin(String token) {
        // 关键点 获取token
        return  checkService.isLogin(token);
    }
    @PostMapping("/auth/permission")
    public boolean checkPermission(String token, String checkUrl) {
        // 1.获取用户权限信息
        // 2.扫描文件url
        // 判断权限是否能够访问
        return false;
    }
}
