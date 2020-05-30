package com.mt.customer.service.impl;

import com.mt.pojo.Customer;
import com.mt.customer.dao.PermissionDao;
import com.mt.customer.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public boolean insertPermission(String permissin) {
        return permissionDao.insertPermission(permissin);
    }

    @Override
    public List<String> listPermission() {
        return permissionDao.listPermission();
    }


}
