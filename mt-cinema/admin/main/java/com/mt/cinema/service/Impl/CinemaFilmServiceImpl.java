package com.mt.cinema.service.Impl;

import com.mt.cinema.dao.CinemaFilmDao;
import com.mt.cinema.entity.CinemaFilmDTO;
import com.mt.cinema.service.CinemaFilmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CinemaFilmServiceImpl  implements CinemaFilmService {
    @Resource
    CinemaFilmDao cinemaFilmDao;
/**
 * 电影院添加电影
 * */
    @Override
    public int addFilmById(Integer filmId,Integer cinemaId) {
        return cinemaFilmDao.addFilmById(filmId,cinemaId);
    }
/**
 * 上下架
 * */
    @Override
    public int releaseShelveFilm(Integer cinemaId, Integer filmId) {
        int isShow =cinemaFilmDao.selectIsShow(cinemaId,filmId);
        if(isShow==0){
            return cinemaFilmDao.releaseFilm(cinemaId,filmId);
        }
        else {
            return cinemaFilmDao.shelveFilm(cinemaId,filmId);
        }
    }
/**
 *  根据电影院id查找电影
 * */
    @Override
    public List<CinemaFilmDTO> selectCinemaFilmList(Integer cinemaId) {
        return cinemaFilmDao.selectCinemaFilmList(cinemaId);
    }
}
