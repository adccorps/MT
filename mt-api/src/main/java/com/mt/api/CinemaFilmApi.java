package com.mt.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "mt-server-cinema")
public interface CinemaFilmApi {
    /**
     * 电影院添加电影
     * */
    @PostMapping(value = "/cinema/{cinemaId}/film/{filmId}")
     Object addFilmById(@PathVariable("filmId") Integer filmId,
                              @PathVariable("cinemaId") Integer cinemaId);

    /**
     * 上下架
     * */
    @PutMapping(value="/cinema/{cinemaId}/film/{filmId}")
     Object releaseShelveFilm(@PathVariable("cinemaId")Integer cinemaId,
                                    @PathVariable("filmId") Integer filmId);

    /**
     *  根据电影院id查找电影
     * */
    @GetMapping(value="cinema/{cinemaId}/films")
     Object selectCinemaFilmList(@PathVariable("cinemaId")Integer cinemaId);
}