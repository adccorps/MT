package com.mt.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy    //开启网关
@EnableEurekaClient//注册服务
public class zuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(zuulApplication.class, args);
    }
}
