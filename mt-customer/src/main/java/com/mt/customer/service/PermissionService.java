package com.mt.customer.service;

import com.mt.pojo.Customer;
import org.apache.ibatis.annotations.Param;

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
    boolean updatePermission(int permissionId, String permissin);
}
