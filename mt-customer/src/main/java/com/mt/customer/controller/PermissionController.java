package com.mt.customer.controller;

import com.mt.customer.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户中心-权限")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping("/permissions")
    @ApiOperation("管理端-数据字典查询权限列表")
    public List<String> listPermission(){
        return permissionService.listPermission();
    }

    @PostMapping("/permission")
    @ApiOperation("管理端-数据字典-添加权限")
    public boolean insertPermission(String permission){
        return permissionService.insertPermission(permission);
    }

    @PutMapping("/permission/{permissionId}")
    @ApiOperation("管理端-数据字典-添加权限")
    public boolean updatePermission(@PathVariable("permissionId") int permissionId, String permission){
        return permissionService.updatePermission(permissionId,permission);
    }

}
