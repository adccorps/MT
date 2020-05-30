package com.mt.customer.controller;


import com.mt.customer.service.CustomerService;
import com.mt.pojo.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "用户中心-用户信息管理")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public boolean registerCustomer(Customer customer) {
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/customer")
    @ApiOperation(value = "用户查看个人信息")
    public Customer getCurrentCustomer(@RequestHeader String token) {
        return customerService.getCustomerByToken(token);
    }

    @GetMapping("/customers")
    @ApiOperation(value = "管理员查询所有用户")
    public List<Customer> listCustomer() {
        return customerService.listAllCustomer();
    }

    @RequestMapping(value = "/customer",method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息")
    public Object updateCustomer( Customer customer ) {
        return customerService.updateCustomer(customer);
    }



}
