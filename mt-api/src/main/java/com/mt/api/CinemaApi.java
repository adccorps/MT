package com.mt.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "mt-server-cinema")
public interface CinemaApi {
    /**
     * 根据id查电影院名字
     */
    @GetMapping(value = "/cinemaServer/cinema/{cinemaId}")
    Object getCinemaNameById(@PathVariable("cinemaId") Integer id);
}
