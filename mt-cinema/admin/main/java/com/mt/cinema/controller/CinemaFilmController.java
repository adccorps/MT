package com.mt.cinema.controller;

import com.mt.cinema.service.CinemaFilmService;
import com.mt.constants.Code;
import com.mt.pojo.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class CinemaFilmController {

    @Resource
    CinemaFilmService cinemaFilmService;
    Result result;

    /**
     * 电影院添加电影
     * */
    @PostMapping(value = "/cinema/{cinemaId}/film/{filmId}")
    public Object addFilmById(@PathVariable("filmId") Integer filmId,@PathVariable("cinemaId") Integer cinemaId) {
        if(cinemaFilmService.addFilmById(filmId,cinemaId)>0){
            result =new Result(Code.OK,"插入成功");
        }else {
            result = new Result(Code.NOT_FOUND,"插入失败");
        }
        return result;
    }
    /**
     * 上下架
     * */
    @PutMapping(value="/cinema/{cinemaId}/film/{filmId}")
    public Object releaseShelveFilm(@PathVariable("cinemaId")Integer cinemaId,
                              @PathVariable("filmId") Integer filmId) {
        if(cinemaFilmService.releaseShelveFilm(cinemaId,filmId)>0){
            result =new Result(Code.OK,"操作成功");
        }else {
            result = new Result(Code.NOT_FOUND,"操作失败");
        }
        return result;
    }
    /**
     *  根据电影院id查找电影
     * */
    @GetMapping(value="cinema/{cinemaId}/films")
    public Object selectCinemaFilmList(@PathVariable("cinemaId")Integer cinemaId) {

            result =new Result(Code.OK,cinemaFilmService.selectCinemaFilmList(cinemaId));

        return result;
    }
}
