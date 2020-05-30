package com.mt.config;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * 加密类
 */
@Component
public class Encryption {
    /**
     * 对密码进行加密处理，salt为空表示不进行盐值加密
     * 在用户注册时，应该把用户的加密密码存进数据库
     */
    public Object md5Encryption(Object credentials, Object salt){
        String hashAlgorithmName = "MD5";//加密方式
        int hashIterations = 1024; //加密次数
        Object encryptionResult = new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        return encryptionResult;
    }
}
