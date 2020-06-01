package com.mt.customer.service;


import com.mt.customer.pojo.CustomerListDTO;
import com.mt.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {
    /**
     * 搜索所有用户信息
     */
    List<CustomerListDTO> listAllCustomer();

    /**
     * 通过id查询用户
     */
    Customer getCustomerById(@Param("customerId") String customerId);

    /**
     * 通过id查询用户
     */
    Customer getCustomerByPhone(@Param("phone") String phone);

    /**
     * 通过用户名查询用户
     */
    Customer getCustomerByName(@Param("customerName") String customerName);

    /**
     * 通过用户登录后的token信息查询用户信息
     */
    Customer getCustomerByToken(@Param("token")String token);

    /**
     * 新增用户
     */
    boolean insertCustomer(@Param("Customer") Customer customer);

    /**
     * 更新用户信息
     */
    boolean updateCustomer(@Param("Customer") Customer customer);

}
