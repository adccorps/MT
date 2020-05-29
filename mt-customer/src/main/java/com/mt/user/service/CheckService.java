package com.mt.user.service;

import com.mt.pojo.Customer;

public interface CheckService {

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
     * 应该返回token给前端
     */
    String login(Customer customer);
}
