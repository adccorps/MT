package com.mt.api;


import com.mt.pojo.Cinema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-cinema")
public interface CinemaAdminApi {
    /**
     * 根据id查电影院名字
     */
    @GetMapping(value = "/cinema/{cinemaId}")
    String getCinemaNameById(@PathVariable("cinemaId") Integer id);

    /**
     * 增加电影院
     * */
    @PostMapping(value = "/cinema")
     Object createCinema(@RequestBody Cinema cinema);

    /**
     * 删除电影院
     * */
    @PostMapping(value = "/cinema/{cinemaId}")
     Object deleteCinemaById(@PathVariable("cinemaId") int id);

    /**
     * 修改电影院
     * */
    @PutMapping(value = "/cinema/{cinemaId}")
     Object updateCinema(@RequestBody Cinema cinema);

    /**
     * 查找电影院列表
     * */
    @GetMapping(value = "/cinemas")
     Object getCinemaDaoList();
}
