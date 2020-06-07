package com.mt.film.service.impl;

import com.mt.api.CommentApi;
import com.mt.film.dao.FilmDao;
import com.mt.pojo.Film;
import com.mt.pojo.FilmInfoDTO;
import com.mt.pojo.FilmType;
import com.mt.film.entity.ListFilmDTO;
import com.mt.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Resource
    private FilmDao filmDao;

    @Autowired
    CommentApi commentApi;

/**
 *创建电影
 *
 * */

    public int createFilm(Film film){
        film.setCreateTime(new Date());
        return filmDao.createFilm(film);
    }

    /**
    根据id查电影
     */
    public FilmInfoDTO getFilmDTOById( int id) {
        Film film = filmDao.getFilmById(id);


        String[] type_id = film.getTypeId().split(",");
        String[] type = new String[type_id.length];
        int a;
        for (a = 0; a < type_id.length; a++) {               //根据type_id查出type
            type[a] = filmDao.getTypeById(Integer.parseInt(type_id[a]));
        }
        //将type信息封装进filmDTO
        //评论信息封装进DTO
        FilmInfoDTO filmInfoDTO = new FilmInfoDTO(film, type, (List<Object>)commentApi.listComment(film.getFilmId()));
        return filmInfoDTO;
    }

    /**
    查询所有电影信息
     */
    public List<ListFilmDTO> getFilmList() {
        return filmDao.getFilmList();
    }

    /**
   根据类型id查电影类型
    */
    public String getTypeById(int id) {
        return filmDao.getTypeById(id);
    }

   /* *//**
     * 根据id删除电影
     *//*

    public int deleteFilm(@Param("id") int id){
        return filmDao.deleteFilm(id);
    }*/


    /**
     * 更新电影信息
     */

    public int updateFilm(Film film){
        return filmDao.updateFilm(film);
    }

    /**
     增加电影类型
     */
    public int createType(FilmType filmType){
        return filmDao.createType(filmType);
    }

/*
    */
/**
     根据类型id删除电影类型
     *//*

    public int deleteTypeById(@Param("type_id") int id){
        return filmDao.deleteTypeById(id);
    }
*/

    /**
     根据类型id修改电影类型
     */
    public int updateType(FilmType filmType){
        return filmDao.updateType(filmType);
    }

    /**
     查询所有类型信息
     */
    public List<FilmType> getFilmTypeList(){
        return filmDao.getFilmTypeList();
    }

}
