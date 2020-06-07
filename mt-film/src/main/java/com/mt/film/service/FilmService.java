package com.mt.film.service;

import com.mt.pojo.Film;
import com.mt.pojo.FilmInfoDTO;
import com.mt.pojo.FilmType;
import com.mt.film.entity.ListFilmDTO;

import java.util.List;

public interface FilmService {
    /**
     * 创建电影
     */
    public int createFilm(Film film);

    /**
     * 根据id查电影
     */
    public FilmInfoDTO getFilmDTOById(int id);

    /**
     * 查询所有电影信息
     */
    public List<ListFilmDTO> getFilmList();

    /**
     * 根据类型id查电影类型
     */
    public String getTypeById(int id);

  /*  *//**
     * 根据id删除电影
     *//*

    public int deleteFilm(@Param("id") int id);
*/

    /**
     * 更新电影信息
     */

    public int updateFilm(Film film);

    /**
     增加电影类型
     */
    public int createType(FilmType filmType);

   /* *//**
     根据类型id删除电影类型
     *//*
    public int deleteTypeById(@Param("type_id") int id);
*/
    /**
     根据类型id修改电影类型
     */
    public int updateType(FilmType filmType);
    /**
     查询所有类型信息
     */
    public List<FilmType> getFilmTypeList();

}
