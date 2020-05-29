package com.mt.user.service.impl;

import com.mt.pojo.Customer;
import com.mt.user.dao.PermissionDao;
import com.mt.user.service.PermissionService;
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
