package com.mt.service.impl;

import com.mt.config.Encryption;
import com.mt.pojo.Messages;
import com.mt.service.MessageService;
import com.mt.service.SMSUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    SMSUtil sMSUtil;
    @Autowired
    Encryption encryption;
    @Autowired
    RedisTemplate<Object, Messages> messageRedisTemplate;

    @RabbitListener(queues = "message.register")
    public void sendRegisterMessage(String phone) {
        String type = "register";
        String code = sMSUtil.sendMessage(phone);
        //对code加密
        Object enCode = encryption.md5Encryption(code, phone);
        //把type、用户手机号码、经过加密的code加入到实体类message中
        Messages message = new Messages(type, phone, enCode.toString());
        //把message实体类加入到redis中，key值为用户的手机号码,并且有效期为5分钟
        messageRedisTemplate.opsForValue().set(message.getPhone(), message, 5, TimeUnit.MINUTES);
    }

    @RabbitListener(queues = "message.login")
    public void sendLoginMessage(String phone) {
        String type = "login";
        String code = sMSUtil.sendMessage(phone);
        //对code加密
        Object enCode = encryption.md5Encryption(code,phone);
        //把type、用户手机号码、经过加密的code加入到实体类message中
        Messages message = new Messages(type,phone,enCode.toString());
        //把message实体类加入到redis中，key值为用户的手机号码,并且有效期为5分钟
        messageRedisTemplate.opsForValue().set(message.getPhone(),message,5, TimeUnit.MINUTES);
    }



}
