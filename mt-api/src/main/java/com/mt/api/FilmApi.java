package com.mt.api;

import com.mt.pojo.Film;
import com.mt.pojo.FilmType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "mt-server-film")
public interface FilmApi {
/**
 * 电影的增改查
 * */

            /**
             * 查询所有电影信息
             */
            @GetMapping(value = "/films")
            Object getFilmList();
            /**
             * 根据id查电影信息
             * */
            @GetMapping("/film/{filmId}")
            Object getFilmDTOById(@PathVariable("filmId") int id);


            /**
             * 增加电影信息
             * */
            @PostMapping(value = "/filmServer/film")
            Object createFilm(@RequestBody Film film);


            /**
             * 更新电影信息
             */
            @PutMapping(value = "filmServer/updateFilm/{filmId}")
            Object updateFilm(@RequestBody Film film);

/**
 * 电影类型的增改查
 * */
            /**
             增加电影类型
             */
            @GetMapping(value = "/filmServer/type")
            Object createType(@RequestBody FilmType filmType);


            /**
             根据类型id修改电影类型
             */
            @GetMapping(value = "/filmServer/type/{type_id}")
            Object updateTypeById(@RequestBody FilmType filmType);


            /**
             查询所有类型信息（列表）
             */
            @GetMapping(value = "/filmServer/types")
            Object getFilmTypeList();
}