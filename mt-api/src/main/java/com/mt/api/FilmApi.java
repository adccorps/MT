package com.mt.api;

import com.mt.pojo.Film;
import com.mt.pojo.FilmType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "mt-server-film")
public interface FilmApi {
/**
 * 电影的增改查
 * */

            /**
             * 查询所有电影信息
             * data FilmInfoDTO
             */
            @GetMapping(value = "/filmServer/films")
            Object getFilmList();
            /**
             * 根据id查电影信息
             * return List<ListFilmDTO>
             * */
            @GetMapping("/filmServer/film/{filmId}")
            Object getFilmById(@PathVariable("filmId") int id);


            /**
             * 增加电影信息
             * data:String
             * */
            @PostMapping(value = "/filmServer/film")
            Object createFilm(@RequestBody Film film);


            /**
             * 更新电影信息
             * data:String
             */
            @PutMapping(value = "filmServer/Film/{filmId}")
            Object updateFilm(@RequestBody Film film);

/**
 * 电影类型的增改查
 * */
            /**
             增加电影类型
             data:String
             */
            @GetMapping(value = "/filmServer/type")
            Object createType(@RequestBody FilmType filmType);


            /**
             根据类型id修改电影类型
             data:String
             */
            @GetMapping(value = "/filmServer/type/{typeId}")
            Object updateTypeById(@RequestBody FilmType filmType);


            /**
             查询所有类型信息（列表）
             data:List<FilmType>
             */
            @GetMapping(value = "/filmServer/types")
            Object getFilmTypeList();
}