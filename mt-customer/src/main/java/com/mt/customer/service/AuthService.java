package com.mt.customer.service;

import com.mt.pojo.Customer;

public interface AuthService {

    /**
     * 检查是否已经登录
     *
     * @param token 验证信息
     * @return true/false
     */
    boolean isLogin(String token);

    /**
     * 检查当前路径是否有权限请求
     *
     * @param permission 用户权限
     * @param checkUrl   当前需要验证的请求路径
     */

    boolean checkPermission(String permission, String checkUrl);

    /**
     * 登录,并且存储到redis
     *
     * @param customer 登录用户信息
     * @return 返回token信息,和用户详细信息,LoginCustomerDTO
     */
    Object login(Customer customer);

    /**
     * 手机短信登录接口
     * @param phone 手机号
     * @param verifiedCode 短信验证码
     * @return LoginCustomerDTO
     */
    Object loginByPhone(String phone, String verifiedCode);



}
