package com.mt.redis.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka
public class eurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication.class, args);
    }
}
