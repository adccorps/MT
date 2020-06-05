package com.mt.admin.controller;

import com.mt.pojo.Cinema;
import com.mt.admin.entity.CinemaDTO;
import com.mt.admin.service.CinemaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class AdminController {
    /**
     * 增加电影院
     * */
    @Resource
    CinemaService cinemaService;


    @PostMapping(value = "/cinemaServer/cinema")
    public String createCinema(@RequestBody Cinema cinema){
        int result = cinemaService.createCinema(cinema);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
     * 删除电影院
     * */
    @PostMapping(value = "/cinemaServer/cinema/{cinemaId}")
    public String deleteCinemaById(@PathVariable("cinemaId") int id){
        int result = cinemaService.deleteCinemaById(id);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
     * 修改电影院
     * */
    @PutMapping(value = "/cinemaServer/cinema/{cinemaId}")
    public String updateCinema(@RequestBody Cinema cinema){
        int result = cinemaService.updateCinema(cinema);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
     * 查找电影院列表
     * */
    @GetMapping(value = "/cinemaServer/cinemas")
    public List<CinemaDTO> getCinemaDaoList(){
        return cinemaService.getCinemaDTOList();
    }
}
