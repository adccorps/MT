package com.mt.film.dao;

import com.mt.film.entity.Film;
import com.mt.film.entity.FilmInfoDTO;
import com.mt.film.entity.ListFilmDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FilmDao {
 /*   *//*
    创建电影
     *//*
    public int createFilm(Film film);
*/
    /*
    根据id查电影具体信息
     */
    public Film getFilmById(@Param("film_id") int id);


    /*
    根据类型id查电影类型
     */
    public String getTypeById(@Param("type_id") int id);
    /*
    查询所有电影信息
     */
    public List<ListFilmDTO> getFilmList();

  /*  *//*
    根据id删除电影
     *//*
    public int deleteFilm(@Param("id") int id);

    *//*
    更新电影信息
     *//*
    public int updateFilm(Film film);*/
}
