package com.mt.user.controller;

import com.mt.user.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @RequestMapping("/login/{user}/{pass}")
    public  void login(@PathVariable("user") String user ,@PathVariable("pass") String pass){
        //通过shiro的token登录
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        UsernamePasswordToken token = new UsernamePasswordToken(user, pass);
        subject.login(token);
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("Token", token);
        check();
        System.out.println("login结束");
//        User u =(User) subject.getPrincipal();
//       return u;

    }
    @RequestMapping("/check")
    public  boolean check(){
        Session session = SecurityUtils.getSubject().getSession();
        boolean s= session.getAttribute("Token")!=null;
        System.out.println(session.getAttribute("Token"));
        return s;
    }
}
