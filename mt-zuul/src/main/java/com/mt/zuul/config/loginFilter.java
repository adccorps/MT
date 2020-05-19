package com.mt.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class loginFilter extends ZuulFilter {
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
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
