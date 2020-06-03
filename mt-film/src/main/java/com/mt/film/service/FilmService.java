package com.mt.film.service;

import com.mt.film.entity.FilmDTO;
import com.mt.film.entity.FilmsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmService {
   /* *//*
   创建电影
    *//*
    public int createFilm(Film film);
*/
    /*
    根据id查电影
     */
    public FilmDTO getFilmById(@Param("id") int id);
    /*
    查询所有电影信息
     */
    public List<FilmsDTO> getFilmList();

    /*
   根据类型id查电影类型
    */
    public String getTypeById(@Param("type_id") int id);
}
