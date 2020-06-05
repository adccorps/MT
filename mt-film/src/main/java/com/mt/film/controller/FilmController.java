package com.mt.film.controller;
import com.mt.film.service.FilmService;
import com.mt.film.entity.*;
import com.mt.pojo.Film;
import com.mt.pojo.FilmType;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class FilmController {
    @Resource
    private FilmService filmService;



    /**
     * 增加电影信息
     * */

    @PostMapping(value = "/filmServer/film")
    public String createFilm(@RequestBody Film film){
        int result = filmService.createFilm(film);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
    根据id查询电影具体信息
     */
    @GetMapping("/filmServer/film/{filmId}")
    public FilmInfoDTO getFilmById(@PathVariable("filmId") int id) {

        return filmService.getFilmDTOById(id);
    }

    /**
     * 查询电影信息列表
     */
    @GetMapping(value = "/films")
    public List<ListFilmDTO> getFilmList() {
        return filmService.getFilmList();
    }

   /* *//**
     * 根据类型id查电影类型
     *//*
    public String getTypeById(@Param("type_id") int id) {
        return filmService.getTypeById(id);
    }*/
/*
    *//**
     * 根据id删除电影
     *//*

    public String deleteFilm(@Param("id") int id){
        int result =filmService.deleteFilm(id);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }*/


    /**
     * 更新电影信息
     */
    @GetMapping(value = "filmServer/updateFilm/{filmId}")
    public String updateFilm(@RequestBody Film film){
        int result =filmService.updateFilm(film);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }

    /**
     增加电影类型
     */
    @GetMapping(value = "/filmServer/type")
    public String createType(@RequestBody FilmType filmType){
        int result =filmService.createType(filmType);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }

  /*  *//**
     根据类型id删除电影类型
     *//*

    public String deleteTypeById(@Param("type_id") int id){
        int result =filmService.deleteTypeById(id);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }*/

    /**
     根据类型id修改电影类型
     */
    @GetMapping(value = "/filmServer/type/{type_id}")
    public String updateTypeById(@RequestBody FilmType filmType){
        int result =filmService.updateType(filmType);
        if(result>0){
            return  "插入成功";
        }else {
            return  "插入失败";
        }
    }
    /**
     查询所有类型信息（列表）
     */
    @GetMapping(value = "/filmServer/types")
    public List<FilmType> getFilmTypeList(){
        return filmService.getFilmTypeList();
    }

}
