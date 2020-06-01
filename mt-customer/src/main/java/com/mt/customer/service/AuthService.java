package com.mt.customer.service;

import com.mt.pojo.Customer;

public interface AuthService {

    /**
     * 检查是否已经登录
     * @return
     */
    boolean isLogin(String token);

    /**
     * 检查当前路径是否有权限请求
     */

    boolean checkPermission(String permission, String checkUrl);

    /**
     * 登录,并且存储到redis
     * 应该返回信息给前端
     * @// TODO: 2020/5/30 需要DTO
     */
    Object login(Customer customer);
    /**
    * 手机短信登录接口
    * */
    Object loginByPhone(String phone,String verifiedCode);


    /**
     * 获取管理员影院id
     * */
    int getCinemaId(String customerId);
}
