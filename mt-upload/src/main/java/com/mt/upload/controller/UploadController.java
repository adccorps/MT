package com.mt.upload.controller;

import com.google.gson.Gson;
import com.mt.constants.Code;
import com.mt.pojo.Result;
import com.mt.upload.services.UploadService;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@Api(tags = "图片上传")
public class UploadController {

    @Autowired
    UploadService uploadService;
    /**
     * 接受post方法，将表单传来的数据插入
     * @return 服务端跳转到announce.html
     */
    @ApiOperation("图片上传")
    @PostMapping("/upload/img")
    public Object addContent(HttpServletRequest request,
                             @RequestParam("file") MultipartFile file){

        DefaultPutRet putRet = null;
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
            putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Result(Code.OK, Objects.requireNonNull(putRet).key);
    }

    // Announce announce, , Model model
    //announceService.save(announce);  //存入数据库
//            announce.setPicture(putRet.key);//这个就是从七牛云获取的文件名
//        return "pic.stadc.cn/"+announce.getPicture();
}
