package com.mt.film.service;

import com.mt.pojo.Film;
import com.mt.pojo.dto.FilmInfoDTO;
import com.mt.pojo.FilmType;
import com.mt.film.entity.ListFilmDTO;

import java.util.List;

public interface FilmService {
    /**
     创建电影
     */
     int createFilm(Film film);

    /**
      根据id查电影
     */
    FilmInfoDTO getFilmDTOById(int id);

    /**
     查询所有电影信息
     */
     List<ListFilmDTO> getFilmList();

    /**
     根据类型id查电影类型
     */
    String getTypeById(int id);



    /**
     更新电影信息
     */

     int updateFilm(Film film);

    /**
     增加电影类型
     */
     int createType(FilmType filmType);


    /**
     根据类型id修改电影类型
     */
     int updateType(FilmType filmType);
    /**
     查询所有类型信息
     */
     List<FilmType> getFilmTypeList();

}
