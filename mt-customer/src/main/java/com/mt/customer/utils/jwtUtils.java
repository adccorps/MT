package com.mt.customer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.pojo.Customer;

public class jwtUtils {
    //加密,获取token
    public static String getToken(Customer customer){
    String jwt = JWT.create().withClaim("customerName", customer.getCustomerName())
            .withClaim("permission", customer.getPermission())
            .sign(Algorithm.HMAC256(customer.getPassword()));
    return jwt;
    }
}
