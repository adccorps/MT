package com.mt.cinema.controller;

import com.mt.cinema.service.CinemaHallService;
import com.mt.constants.Code;
import com.mt.pojo.CinemaHall;
import com.mt.pojo.Result;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class CinemaHallController {
    @Resource
    CinemaHallService cinemaHallService;
    Result result;

    /**
     电影厅增加
     */
    @PostMapping(value = "/cinema/{cinemaId}/hall")
    public Object addCinemaHall(@RequestBody CinemaHall cinemaHall){
        if(cinemaHallService.addCinemaHall(cinemaHall)>0){
            result = new Result(Code.OK,"操作成功");
        }else {
            result = new Result(Code.NOT_FOUND,"操作失败");
        }
        return  result;
    }
    /**
     电影厅列表
     */
    @GetMapping(value="/cinema/{cinemaId}/halls")
    public Object cinemaHallList(@PathVariable("cinemaId") Integer cinemaId){
        result = new Result(Code.OK,cinemaHallService.cinemaHallList(cinemaId));
        return result;
    }
    /**
     电影厅修改
     */
    @PutMapping(value="/cinema/hall/{hallId}")
    public Object updateCinemaHall(CinemaHall cinemaHall){
        if(cinemaHallService.updateCinemaHall(cinemaHall)>0){
            result = new Result(Code.OK,"操作成功");
        }else {
            result = new Result(Code.NOT_FOUND,"操作失败");
        }
        return  result;
    }

}
