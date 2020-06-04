package com.mt.customer.controller;


import com.mt.constants.Code;
import com.mt.customer.pojo.LoginCustomerDTO;
import com.mt.pojo.Customer;
import com.mt.pojo.Result;
import com.mt.customer.service.AuthService;
import com.mt.customer.service.CustomerService;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户中心-登录/授权")
public class AuthController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthService authService;


    @PostMapping("/login")
    @ApiOperation(value = "用户密码登录接口")
    public Object login(@RequestParam(" customerName") String customerName, @RequestParam ("password") String password) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setPassword(password);
        LoginCustomerDTO loginCustomerDTO = (LoginCustomerDTO) authService.login(customer);
        Result result = new Result(Code.OK, loginCustomerDTO);
        return result;
    }

    @PostMapping("/login/{phone}")
    @ApiOperation(value = "用户手机短信登录接口")
    public Object loginByPhone(@PathVariable("phone") String phone, @RequestParam("verifiedCode") String verifiedCode) {
        LoginCustomerDTO loginCustomerDTO = (LoginCustomerDTO) authService.loginByPhone(phone, verifiedCode);
        Result result = new Result(Code.OK, loginCustomerDTO);
//        Object o = JSON.toJSONString(result);
        return result;
    }


    /**
     * @RequestHeader String token
     * 从请求头获取 问题点:使用requestBody时会返回400 bad request错误
     */
    @PostMapping("/auth/login")
    @ApiOperation(value = "登录检测接口")
    public Object checkLogin(@RequestHeader String token) {
        Result result = new Result(Code.OK, authService.isLogin(token));
        return result;
    }

    @PostMapping("/auth/permission")
    @ApiOperation(value = "url请求权限检测")
    public Object checkPermission(@RequestHeader String token, String checkUrl) {
        Result result = new Result(Code.OK, authService.checkPermission(token, checkUrl));
        return result;
    }



}
