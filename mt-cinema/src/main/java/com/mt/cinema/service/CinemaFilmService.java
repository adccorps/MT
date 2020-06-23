package com.mt.cinema.service;

import com.mt.cinema.entity.CinemaFilmDTO;

import java.util.List;

public interface CinemaFilmService {
    /**
     * 电影院添加电影
     * */
    int addFilmById(Integer filmId, Integer cinemaId);
    /**
     * 上下架
     * */
    int releaseShelveFilm(Integer cinemaId,Integer filmId);
    /**
     * 查找已添加电影列表
     * */
    List<CinemaFilmDTO> selectCinemaFilmList(Integer cinemaId);
}
