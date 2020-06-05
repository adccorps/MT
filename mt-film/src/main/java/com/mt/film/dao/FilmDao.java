package com.mt.film.dao;

import com.mt.pojo.Film;
import com.mt.pojo.FilmType;
import com.mt.film.entity.ListFilmDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface FilmDao {
   /**
    *   创建电影
    */

    public int createFilm(Film film);


    /**
    根据id查电影具体信息
     */
    public Film getFilmById(@Param("filmId") int id);


    /**
    根据类型id查电影类型
     */
    public String getTypeById(@Param("typeId") int id);

   /**
    增加电影类型
    */
   public int createType(FilmType filmType);

   /**
    根据类型id删除电影类型
    */
   public int deleteTypeById(@Param("typeId") int id);

   /**
    修改电影类型
    */
   public int updateType(FilmType filmType);

 /**
    查询所有电影信息
     */
    public List<ListFilmDTO> getFilmList();

 /**
  查询所有类型信息
  */
 public List<FilmType> getFilmTypeList();

/* *
     * 根据id删除电影

    public int deleteFilm(@Param("id") int id);*/


   /**
    * 更新电影信息
    */

    public int updateFilm(Film film);
}
