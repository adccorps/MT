package com.mt.user.controller;

import com.mt.pojo.Result;
import com.mt.user.pojo.Customer;
import com.mt.user.service.CheckService;
import com.mt.user.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
//        System.out.println(checkService.login(customer));
        return checkService.login(customer);
    }

    @PostMapping("/auth/login")
    @ApiOperation(value = "登录检测接口")
    public boolean checkLogin(@RequestBody String token) {
//        Result result = new Result(checkService.isLogin(token));
        return checkService.isLogin(token);
    }

    @PostMapping("/auth/permission")
    public boolean checkPermission(String token, String checkUrl) {
        // 1.获取用户权限信息
        // 2.扫描文件url
        // 判断权限是否能够访问
        return false;
    }
}
