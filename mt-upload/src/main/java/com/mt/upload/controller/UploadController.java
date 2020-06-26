package com.mt.upload.controller;

import com.mt.entity.Announce;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import com.mt.upload.services.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@Api(tags = "圖片上傳")
public class UploadController {

    @Autowired
    UploadService uploadService;
    /**
     * 接受post方法，将表单传来的数据插入
     * @param announce com.lingfei.admin.entity.Announce
     * @return 服务端跳转到announce.html
     */
    @ApiOperation("圖片上傳")
    @PostMapping("/upload/img")
    public String addContent(Announce announce, HttpServletRequest request,
                             @RequestParam("file") MultipartFile file, Model model){
        try{
            //根据时间戳创建文件名
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //创建文件的实际路径
            String destFileName = request.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //根据文件路径创建文件对应的实际文件
            File destFile = new File(destFileName);
            //创建文件实际路径
            destFile.getParentFile().mkdirs();
            //将文件传到对应的文件位置
            file.transferTo(destFile);
            Response response = uploadService.uploadFile(destFile);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            announce.setPicture(putRet.key);//这个就是从七牛云获取的文件名
        }catch (IOException e){
            e.printStackTrace();
        }
        //announceService.save(announce);  //存入数据库
        return "pic.stadc.cn/"+announce.getPicture();
    }

}
