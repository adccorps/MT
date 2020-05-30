package com.mt.customer.controller;

import com.alibaba.fastjson.JSON;
import com.mt.customer.pojo.LoginCustomerDTO;
import com.mt.pojo.Customer;
import com.mt.pojo.Result;
import com.mt.customer.service.AuthService;
import com.mt.customer.service.CustomerService;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户中心-登录/授权")
public class AuthController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    @ApiOperation(value = "result结果测试")
    public Object test() {
        Customer customer = new Customer();
        customer.setCustomerName("ceshi");
        customer.setPassword("12321312");
        Result result = new Result("200", customer);
        Object o = JSON.toJSONString(result);
        return o;
    }

    /**
     * @// TODO: 2020/5/30 需要修改
     *
     */
    @PostMapping("/login/{customerName}/{password}")
    @ApiOperation(value = "用户密码登录接口")
    public Object login(@PathVariable("customerName") String customerName, @PathVariable("password") String password) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setPassword(password);

        LoginCustomerDTO loginCustomerDTO = (LoginCustomerDTO) authService.login(customer);
        Result result = new Result("200", loginCustomerDTO);
        Object o = JSON.toJSONString(result);
        return o;
    }
    @PostMapping("/login/{phone}")
    @ApiOperation(value = "用户手机短信登录接口")
    public Object loginByPhone(@PathVariable("phone") String phone,String verifiedCode) {


        LoginCustomerDTO loginCustomerDTO = (LoginCustomerDTO) authService.loginByPhone(phone,verifiedCode);
        Result result = new Result("200", loginCustomerDTO);
        Object o = JSON.toJSONString(result);
        return o;
    }


    /**
     * @RequestHeader String token
     * 从请求头获取 问题点:使用requestBody时会返回400 bad request错误
     */
    @PostMapping("/auth/login")
    @ApiOperation(value = "登录检测接口")
    public boolean checkLogin(@RequestHeader String token) {
        return authService.isLogin(token);
    }

    @PostMapping("/auth/permission")
    @ApiOperation(value = "url请求权限检测")
    public boolean checkPermission(@RequestHeader String token, String checkUrl) {
        return authService.checkPermission(token, checkUrl);
    }


}
