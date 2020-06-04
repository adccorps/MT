package com.mt.api;


import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user" )
public interface AuthApi {

    @PostMapping("/login")
    Object login(@RequestParam(" customerName") String customerName, @RequestParam ("password") String password);

    @PostMapping("/auth/login" )
    boolean checkLogin(@RequestHeader String token);

    @PostMapping("/auth/permission")
    boolean checkPermission(@RequestHeader String token, @RequestParam("checkUrl")String checkUrl);

    @PostMapping("/login/{phone}")
    Object loginByPhone(@PathVariable("phone") String phone, @RequestParam("verifiedCode") String verifiedCode);

    @GetMapping("/cinema")
     Object getCinemaId(@RequestHeader String token);
}
