package com.mt.customer.service.impl;


import com.mt.pojo.Customer;
import com.mt.customer.dao.CustomerDao;

import com.mt.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
   private CustomerDao CustomerDao;

    /**
     * 搜索所有用户信息
     * @return
     */
    @Override
    public List<Customer> listAllCustomer() {
        return CustomerDao.listAllCustomer();
    }

    /**
     * 通过id查询用户
     */
    @Override
    public Customer getCustomerById(String customerId) {
        return CustomerDao.getCustomerById(customerId);
    }

    /**
     * 通过用户名查询用户
     */
    @Override
    public Customer getCustomerByName(String customerName) {
        return CustomerDao.getCustomerByName(customerName);
    }

    /**
     * 新增用户
     */
    @Override
    public boolean insertCustomer(Customer customer) {
        return CustomerDao.insertCustomer(customer);
    }

    /**
     * 更新用户信息
     * @TODO:  头像更新需要等待文件上传服务
     */
    @Override
    public boolean updateCustomer(Customer customer) {
        return CustomerDao.updateCustomer(customer);
    }

}
