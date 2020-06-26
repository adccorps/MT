package com.mt.upload.config;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class QiniuUtil {

    //七牛云配置
    public final String accessKey="eXZ013mEe7E9jgbxQmdwx1SpXxQTK3ooiBJ-fpJP";
    public final String secretKey="Kl6_ZdMtWLjXnrFtSo11cwKbrOcxxhhNoIM4l8gv";
    public final String bucket="pztws";
    public final String path="http://pic.stadc.cn";

}
