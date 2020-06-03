package com.mt.film.service.impl;

import com.mt.film.dao.FilmDao;
import com.mt.film.entity.FilmDTO;
import com.mt.film.entity.FilmsDTO;
import com.mt.film.service.FilmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Resource
    private FilmDao filmDao;

  /*  *//*
  创建电影
   *//*
    public int createFilm(Film film){
        return filmDao.createFilm(film);
    }
*/

    /*
    根据id查电影
     */
    public FilmDTO getFilmById(@Param("film_id") int id){
        return filmDao.getFilmById(id);
    }

    /*
    查询所有电影信息
     */
    public List<FilmsDTO> getFilmList(){
        return filmDao.getFilmList();
    };

    /*
   根据类型id查电影类型
    */
    public String getTypeById(@Param("type_id") int id){
        return filmDao.getTypeById(id);
    };
}
