package com.mt.customer.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionDao {

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
     * */
    boolean updatePermission(@Param("permissionId") int permissionId, @Param("permission") String permissin);
}
