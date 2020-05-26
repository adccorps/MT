package com.mt.zuul.config;

import com.mt.UserApi;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
* 登录过滤器,主要过滤支付,订单模块
 * 根据配置文件中的路径拦截
* */
@Configuration
public class LoginFilter extends ZuulFilter {
    /*
    * “pre” 预过滤器 - 在路由分发一个请求之前调用。
    *  “post” 后过滤器 - 在路由分发一个请求后调用。
    *  “route” 路由过滤器 - 用于路由请求分发。
    *  "error” 错误过滤器 - 在处理请求时发生错误时调用
    * */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Autowired
    UserApi userService ;
    @Override
    public Object run() throws ZuulException {
        //Zull的Filter链间通过RequestContext传递通信，内部采用ThreadLocal 保存每个请求的信息，
        //包括请求路由、错误信息、HttpServletRequest、response等
        RequestContext ctx = RequestContext.getCurrentContext();
        System.out.println("------------执行登录filter");
        HttpServletRequest request=getHttpServletRequest();
       userService.check();
        System.out.println(userService.check());
        if (request.getSession().getAttribute("Token")!=null){
        String token = request.getSession().getAttribute("Token").toString();
        System.out.println(token);
        }

        return null;
    }
    private HttpServletRequest getHttpServletRequest() {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setCORS(RequestContext ctx) {
        //处理跨域问题
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        // 这些是对请求头的匹配，网上有很多解释
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods","GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Headers","authorization, content-type");
        response.setHeader("Access-Control-Expose-Headers","X-forwared-port, X-forwarded-host");
        response.setHeader("Vary","Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
    }
}
