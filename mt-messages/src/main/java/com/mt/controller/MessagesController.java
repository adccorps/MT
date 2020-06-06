package com.mt.controller;

import com.mt.constants.Code;
import com.mt.pojo.Result;
import com.mt.service.VeificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {
    @Autowired
    private VeificationService veificationService;

    /**
     * 注册验证码
     * @param phone
     * @return
     */
    @RequestMapping("/register/message")
    public Result requestRegisterCode(String phone){
        veificationService.sendRegisterCode(phone);
        Result MessagesResult = new Result(Code.OK,null);
        return MessagesResult;
    }

    /**
     * 直接使用手机号码登录验证码
     * @param phone
     * @return
     */
    @RequestMapping("/login/message")
    public Result requestLoginCode(String phone){
        veificationService.sendLoginCode(phone);
        Result MessagesResult = new Result(Code.OK,null);
        return MessagesResult;
    }
}
