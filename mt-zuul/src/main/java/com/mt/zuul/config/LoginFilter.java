package com.mt.zuul.config;




import com.mt.api.AuthApi;
import com.mt.constants.Code;
import com.mt.exception.ResultException;
import com.mt.pojo.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;


/**
 * 登录过滤器,主要过滤支付,订单模块
 * 根据配置文件中的路径拦截
 */
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

    // 获取yml中配置的服务名
    private static Set<String> urlSet;

    @Value("${urlSet}")
    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }


    @Autowired
    AuthApi authApi;

    @Override
    public Object run() throws ZuulException {
        //Zull的Filter链间通过RequestContext传递通信，内部采用ThreadLocal 保存每个请求的信息，
        //包括请求路由、错误信息、HttpServletRequest、response等
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = getHttpServletRequest();

        String checkUrl = request.getRequestURI();
        //获取前端的token
        String token = request.getHeader("token");
        if (token != null) {
            // 验证token
            if (!authApi.checkLogin(token)) throw new ResultException(Code.UNAUTHORIZED);
            if (!authApi.checkPermission(token, checkUrl)) throw new ResultException(Code.UNAUTHORIZED);

        }else  {// 对游客的访问进行限制
//            if (!urlSet.contains(request.getRequestURI())) throw new ResultException(Code.UNAUTHORIZED);
            boolean isVisitorPass=false;
            for (String url: urlSet) {
               if (checkUrl.matches(url)) {
                   isVisitorPass =true;
               }
            }
            if( ! isVisitorPass) throw new ResultException(Code.UNAUTHORIZED);
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
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type");
        response.setHeader("Access-Control-Expose-Headers", "X-forwared-port, X-forwarded-host");
        response.setHeader("Vary", "Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
    }
}


