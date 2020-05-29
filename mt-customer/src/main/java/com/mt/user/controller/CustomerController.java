package com.mt.user.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mt.pojo.Customer;
import com.mt.pojo.Result;

import com.mt.user.service.CheckService;
import com.mt.user.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;


@RestController
@Api(tags = "用户服务")
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
        return checkService.login(customer);
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
        return checkService.isLogin(token);
    }

    @PostMapping("/auth/permission")
    public boolean checkPermission(@RequestHeader String token, String checkUrl) {
        return  checkService.checkPermission(token,checkUrl);
    }
}
