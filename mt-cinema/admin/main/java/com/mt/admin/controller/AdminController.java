package com.mt.admin.controller;

import com.mt.constants.Code;
import com.mt.pojo.Cinema;
import com.mt.admin.entity.CinemaDTO;
import com.mt.admin.service.CinemaService;
import com.mt.pojo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class AdminController {

    @Resource
    CinemaService cinemaService;
    Result result;
    /**
     * 增加电影院
     * */
    @PostMapping(value = "/cinema")
    public Object createCinema(@RequestBody Cinema cinema){
        if(cinemaService.createCinema(cinema)>0){
            result = new Result(Code.OK,"插入成功");
        }else {
            result = new Result(Code.OK,"插入失败");
        }
        return  result;
    }
    /**
     * 删除电影院
     * */
    @PostMapping(value = "/cinema/{cinemaId}")
    public Object deleteCinemaById(@PathVariable("cinemaId") int id){
        if(cinemaService.deleteCinemaById(id)>0){
            result = new Result(Code.OK,"插入成功");
        }else {
            result = new Result(Code.OK,"插入失败");
        }
        return  result;
    }
    /**
     * 修改电影院
     * */
    @PutMapping(value = "/cinema/{cinemaId}")
    public Object updateCinema(@RequestBody Cinema cinema){

        if(cinemaService.updateCinema(cinema)>0){
            result = new Result(Code.OK,"插入成功");
        }else {
            result = new Result(Code.OK,"插入失败");
        }
        return  result;
    }
    /**
     * 查找电影院列表
     * */
    @GetMapping(value = "/cinemas")
    public Object getCinemaDaoList(){
        result = new Result(Code.OK,cinemaService.getCinemaDTOList());
        return result;
    }
    /**
     * 根据id查找电影院name
     * */
    @GetMapping(value = "/cinema/{cinemaId}")
    public  String getCinemaNameById(@PathVariable("cinemaId") Integer id){
        return cinemaService.getCinemaNameById(id);
    }
}
