package com.mt.api;

import com.mt.constants.Code;
import com.mt.pojo.Customer;
import com.mt.pojo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user")
public interface CustomerApi {

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    Object registerCustomer(@RequestBody Customer customer);

    @GetMapping("/customer")
    @ApiOperation(value = "用户查看个人信息")
    Object getCurrentCustomer(@RequestHeader String token);


    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息")
    Object updateCustomer(@RequestBody Customer customer);

    @GetMapping("/customer/customerName/{customerName}")
    @ApiOperation(value = "用户名是否存在")
    Object existCustomerName(@PathVariable("customerName") String customerName);

    @GetMapping("/customer/phone/{phone}")
    @ApiOperation(value = "用户手机是否已注册 ")
    Object existPhone(@PathVariable("phone") String phone);

    @GetMapping("/customers")
    @ApiOperation(value = "管理员查询所有用户")
    Object listCustomer();

    @GetMapping("/cinema")
    @ApiOperation(value = "管理员查询管理影院id")
    Object getCinemaId(@RequestHeader String token);
}
