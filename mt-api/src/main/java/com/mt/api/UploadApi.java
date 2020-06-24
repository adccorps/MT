package com.mt.api;

import com.mt.pojo.Announce;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Component
@FeignClient(value = "mt-server-upload")
public interface UploadApi {

    @ApiOperation("插入数据")
    @PostMapping("/admin/addContent")
    public String addContent(Announce announce, HttpServletRequest request,
                             @RequestParam("file") MultipartFile file, Model model);
}


