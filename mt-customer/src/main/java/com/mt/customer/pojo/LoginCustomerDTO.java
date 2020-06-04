package com.mt.customer.pojo;

import com.mt.pojo.Customer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 用户登录后传输对象
 * 传输用户信息以及token
 * */
@ApiModel
public class LoginCustomerDTO {
    @ApiModelProperty(name="token",value="xxxx2",example="examle11211")
    public String token;
    public Customer customer;

    public LoginCustomerDTO( Customer customer,String token) {
        this.token = token;
        customer.setPassword(null);
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        customer.setPassword(null);
        this.customer = customer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
