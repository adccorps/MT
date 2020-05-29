package com.mt;


import com.mt.pojo.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-user" )
public interface CustomerApi {

    @PostMapping("/login")
    Object login();

    @RequestMapping(value = "/auth/login", method =RequestMethod.POST )
    boolean checkLogin(@RequestHeader String token);

    @PostMapping("/login/{user}/{pass}")
    String login(@PathVariable("user") String user, @PathVariable("pass") String pass);

    @PostMapping("/auth/permission")
    boolean checkPermission(@RequestHeader String token, @RequestParam("checkUrl")String checkUrl);
}
