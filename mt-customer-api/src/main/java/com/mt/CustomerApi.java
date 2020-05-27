package com.mt;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user")
public interface CustomerApi {
    @GetMapping("/auth/login")
    boolean checkLogin();

    @PostMapping("/login/{user}/{pass}")
    String login(@PathVariable("user") String user, @PathVariable("pass") String pass);

    @PostMapping("/auth/permission")
    boolean checkPermission(@RequestParam("token")String token, @RequestParam("checkUrl")String checkUrl);
}
