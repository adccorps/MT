package com.mt.customer.controller;

import com.mt.constants.Code;
import com.mt.customer.service.PermissionService;
import com.mt.exception.ResultException;
import com.mt.pojo.Result;
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
    public Object listPermission(){
        return new Result(Code.OK, permissionService.listPermission());
    }

    @PostMapping("/permission")
    @ApiOperation("管理端-数据字典-添加权限")
    public Object insertPermission( @RequestParam("permission")String permission){
        if (permission==null || permission==""){
            throw new ResultException(Code.UNSUPPORTED_MEDIA_TYPE);
        }
        return new Result(Code.OK, permissionService.insertPermission(permission));
    }

    @PutMapping("/permission/{permissionId}")
    @ApiOperation("管理端-数据字典-修改权限")
    public Object updatePermission(@PathVariable("permissionId") Integer permissionId,@RequestParam("permission") String permission){
        return new Result(Code.OK, permissionService.updatePermission(permissionId,permission));
    }

}
