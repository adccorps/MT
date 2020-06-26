package com.mt.upload.services.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.mt.upload.config.QiniuUtil;
import com.mt.upload.services.UploadService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class UploadServiceImpl implements UploadService, InitializingBean {
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private Auth auth;
    @Autowired
    private QiniuUtil qiNiuProperties;
    private StringMap putPolicy;
    String key = null;
    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, key, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3) { // 3次重试
            response = this.uploadManager.put(file, key, getUploadToken());
            retry++;
        }
        return response;
    }
    /**
     * 获取上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return this.auth.uploadToken(qiNiuProperties.getBucket(), key, 3600, putPolicy);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }
}
