package com.mt.cinema.dao;

import com.mt.cinema.entity.CinemaFilmDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CinemaFilmDao {
    /**
     * 电影院添加电影
     */
    int addFilmById(@Param("filmId") Integer filmId, @Param("cinemaId") Integer cinemaId);

    /**
     * 上架
     */
    int releaseFilm(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId);

    /**
     * 下架
     */
    int shelveFilm(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId);

    /**
     * 查找已添加电影列表
     */
    List<CinemaFilmDTO> selectCinemaFilmList(@Param("cinemaId") Integer cinemaId);

    /**
     * 根据id查是否上映
     */
    int selectIsShow(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId);
}
