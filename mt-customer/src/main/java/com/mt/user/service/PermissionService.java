package com.mt.user.service;

import com.mt.user.pojo.Customer;
import org.apache.ibatis.annotations.Param;

public interface PermissionService {
    /**
     * 通过权限id查询对应权限
     * */
    String getPermissionById(@Param("permissionId") Integer permissionId);

    /**
     * 查询用户的权限
     * */
    String getPermissionByCustomer(@Param("customer") Customer customer);

    /**
     * 添加权限信息
     * 用于后台权限管理
     * */
    boolean insertPermission(String permissin);

}
