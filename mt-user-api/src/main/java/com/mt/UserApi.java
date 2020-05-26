package com.mt;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "mt-server-user")
public interface UserApi {
    @RequestMapping("/check")
    boolean check();

}
