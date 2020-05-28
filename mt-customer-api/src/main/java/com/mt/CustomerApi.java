package com.mt;


import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user")
public interface CustomerApi {
    @RequestMapping(value = "/auth/login", method =RequestMethod.POST )
    boolean checkLogin(@RequestBody String token);

    @PostMapping("/login/{user}/{pass}")
    String login(@PathVariable("user") String user, @PathVariable("pass") String pass);

    @PostMapping("/auth/permission")
    boolean checkPermission(@RequestParam("token")String token, @RequestParam("checkUrl")String checkUrl);
}
