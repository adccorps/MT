package com.mt.api;

import com.mt.pojo.CinemaHall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "mt-server-cinema")
public interface CinemaHallApi {
    /**
     电影厅增加
     */
    @PostMapping(value = "/cinema/{cinemaId}/hall")
    Object addCinemaHall(@RequestBody CinemaHall cinemaHall);

    /**
     电影厅列表
     */
    @GetMapping(value="/cinema/{cinemaId}/halls")
     Object cinemaHallList(@PathVariable("cinemaId") Integer cinemaId);

    /**
     电影厅修改
     */
    @PutMapping(value="/cinema/hall/{hallId}")
     Object updateCinemaHall(CinemaHall cinemaHall);
}
