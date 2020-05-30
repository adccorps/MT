package com.mt.customer.service.impl;


import com.auth0.jwt.JWT;
import com.mt.customer.utils.Encryption;
import com.mt.customer.utils.IdUtils;
import com.mt.pojo.Customer;
import com.mt.customer.dao.CustomerDao;

import com.mt.customer.service.CustomerService;
import com.mt.redis.RedisUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
   private CustomerDao CustomerDao;
    @Autowired
    RedisUtils redisUtils;
    /**
     * 获取个人用户信息
     * @return
     */
  public Customer getCustomerByToken(String token){
       String customerName = JWT.decode(token).getClaim("customerName").asString();
       String customerId = (String) redisUtils.hget(customerName,"id");
      return getCustomerById(customerId);
   }
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
     * 通过手机查询用户
     */
    @Override
    public Customer getCustomerByPhone(String Phone) {
        return CustomerDao.getCustomerByPhone(Phone);
    }

    /**
     * 新增用户
     */
    @Override
    public boolean insertCustomer(Customer customer) {
        //加密处理
        customer.setCustomerId(IdUtils.getPrimaryKey());
        ByteSource salt = ByteSource.Util.bytes(customer.customerId);
        Object result = Encryption.md5Encryption(customer.password, salt);
        customer.setPassword(result.toString());
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
