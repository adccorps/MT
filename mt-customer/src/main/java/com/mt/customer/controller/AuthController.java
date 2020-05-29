package com.mt.customer.controller;

import com.alibaba.fastjson.JSON;
import com.mt.pojo.Customer;
import com.mt.pojo.Result;
import com.mt.customer.service.AuthService;
import com.mt.customer.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户登录授权服务")
public class AuthController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthService authService;


    @PostMapping("/login/{user}/{pass}")
    @ApiOperation(value = "登录测试接口")
    public String login(@PathVariable("user") String user, @PathVariable("pass") String pass) {
        Customer customer = new Customer();
        customer.setCustomerName(user);
        customer.setPassword(pass);
        return authService.login(customer);
    }
    @PostMapping("/login")
    @ApiOperation(value = "登录测试")
    public Object login() {
        Customer customer = new Customer();
        customer.setCustomerName("ceshi");
        customer.setPassword("12321312");
        Result result = new Result("200", customer);
        Object o= JSON.toJSONString(result);
        return o;
    }


    /**
     * @RequestHeader String token
     * 从请求头获取 问题点:使用requestBody时会返回400 bad request错误
     * */
    @PostMapping("/auth/login")
    @ApiOperation(value = "登录检测接口")
    public boolean checkLogin(@RequestHeader String token) {
        return authService.isLogin(token);
    }

    @PostMapping("/auth/permission")
    @ApiOperation(value = "url请求权限检测")
    public boolean checkPermission(@RequestHeader String token, String checkUrl) {
        return  authService.checkPermission(token,checkUrl);
    }
}
