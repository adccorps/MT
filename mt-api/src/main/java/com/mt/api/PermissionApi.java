package com.mt.api;

import com.mt.constants.Code;
import com.mt.exception.ResultException;
import com.mt.pojo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user" )
public interface PermissionApi {
    @GetMapping("/permissions")
    @ApiOperation("管理端-数据字典查询权限列表")
     Object listPermission();

    @PostMapping("/permission")
    @ApiOperation("管理端-数据字典-添加权限")
     Object insertPermission(@RequestParam("permission") String permission);

    @PutMapping("/permission/{permissionId}")
    @ApiOperation("管理端-数据字典-修改权限")
     Object updatePermission(@PathVariable("permissionId") int permissionId,@RequestParam("permission") String permission);
}
