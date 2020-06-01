package com.mt.customer.service.impl;

import com.mt.pojo.Customer;
import com.mt.customer.dao.PermissionDao;
import com.mt.customer.service.PermissionService;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 管理端,数据字典修改权限名
     */
    public boolean updatePermission(int permissionId, String permissin) {
        return permissionDao.updatePermission(permissionId,permissin);
    }
}
