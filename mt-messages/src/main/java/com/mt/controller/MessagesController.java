package com.mt.controller;

import com.mt.constants.Code;
import com.mt.pojo.Result;
import com.mt.service.VeificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "验证码验证接口", tags = { "电影访问接口" })
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
    @ApiOperation(value = "登录验证，根据手机号码发送验证码")
    @RequestMapping("/login/message")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "发送成功"),
    @ApiResponse(code = 500, message = "发送失败")})
    public Result requestLoginCode(String phone){
        Result MessagesResult;
        if(phone == null){
            MessagesResult = new Result(Code.INTERNAL_SERVER_ERROR,null);
        }else{
            veificationService.sendLoginCode(phone);
            MessagesResult = new Result(Code.OK,null);
        }
        return MessagesResult;
    }
}
