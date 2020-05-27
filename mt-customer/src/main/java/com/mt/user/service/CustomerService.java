package com.mt.user.service;


import com.mt.user.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    /**
     * 搜索所有用户信息
     */
    List<Customer> listAllCustomer();

    /**
     * 通过id查询用户
     */
    Customer getCustomerById(@Param("customerId") String customerId);

    /**
     * 通过用户名查询用户
     */
    Customer getCustomerByName(@Param("customerName") String customerName);

    /**
     * 新增用户
     */
    boolean insertCustomer(@Param("Customer") Customer customer);

    /**
     * 更新用户信息
     */
    boolean updateCustomer(@Param("Customer") Customer customer);

}
