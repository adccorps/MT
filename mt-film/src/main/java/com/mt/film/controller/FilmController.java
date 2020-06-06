package com.mt.film.controller;
import com.mt.constants.Code;
import com.mt.film.service.FilmService;
import com.mt.film.entity.*;
import com.mt.pojo.Film;
import com.mt.pojo.FilmType;
import com.mt.pojo.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class FilmController {
    @Resource
    private FilmService filmService;

    Result result;


    /**
     * 增加电影信息
     * */

    @PostMapping(value = "/film")
    public Object createFilm(@RequestBody Film film){

        if(filmService.createFilm(film)>0){
            result = new Result(Code.OK, "插入成功");
        }else {
            result = new Result(Code.NOT_FOUND, "插入失败");
        }
        return result;
    }
    /**
    根据id查询电影具体信息
     */
    @GetMapping("/film/{filmId}")
    public FilmInfoDTO getFilmById(@PathVariable("filmId") int id) {

        return filmService.getFilmDTOById(id);
    }

    /**
     * 查询电影信息列表
     */
    @GetMapping(value = "/films")
    public Object getFilmList() {
            result = new Result(Code.OK, filmService.getFilmList());
        return result;
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
    @PutMapping(value = "/Film/{filmId}")
    public Object updateFilm(@RequestBody Film film){
        if(filmService.updateFilm(film)>0){
            result = new Result(Code.OK, "update成功");
        }else {
            result = new Result(Code.NOT_FOUND, "update失败");
        }
        return result;
    }

    /**
     增加电影类型
     */
    @GetMapping(value = "/type")
    public Object createType(@RequestBody FilmType filmType){
        if(filmService.createType(filmType)>0){
            result = new Result(Code.OK, "createType成功");
        }else {
            result = new Result(Code.NOT_FOUND, "createType失败");
        }
        return result;
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
    @GetMapping(value = "type/{typeId}")
    public Object updateTypeById(@RequestBody FilmType filmType){

        if(filmService.updateType(filmType)>0){
            result = new Result(Code.OK, "update成功");
        }else {
            result = new Result(Code.NOT_FOUND, "update失败");
        }
        return result;
    }
    /**
     查询所有类型信息（列表）
     */
    @GetMapping(value = "/types")
    public Object getFilmTypeList(){
        result = new Result(Code.OK, filmService.getFilmTypeList());
        return result;
    }

}
