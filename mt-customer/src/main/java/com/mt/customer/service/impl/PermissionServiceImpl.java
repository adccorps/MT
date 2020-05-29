package com.mt.customer.service.impl;

import com.mt.pojo.Customer;
import com.mt.customer.dao.PermissionDao;
import com.mt.customer.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public String getPermissionById(Integer permissionId) {
        return permissionDao.getPermissionById(permissionId);
    }

    @Override
    public String getPermissionByCustomer(Customer customer) {
        return permissionDao.getPermissionByCustomer(customer);
    }

    @Override
    public boolean insertPermission(String permissin) {
        return permissionDao.insertPermission(permissin);
    }

}
