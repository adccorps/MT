package com.mt.customer.service;


import java.util.List;

public interface PermissionService {
    /**
     * 添加权限信息
     * 用于后台权限管理
     * */
    boolean insertPermission(String permissin);

    /**
     * 管理端,数据字典查询权限
     * */
    List<String> listPermission();
    /**
     * 管理端,数据字典修改权限名
     */
    boolean updatePermission(Integer permissionId, String permissin);
}
