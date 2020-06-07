package com.mt.cinema.service.Impl;

import com.mt.cinema.dao.CinemaHallDao;
import com.mt.cinema.entity.CinemaHallDTO;
import com.mt.cinema.service.CinemaHallService;
import com.mt.pojo.CinemaHall;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Resource
    CinemaHallDao cinemaHallDao;


    @Override
    public int addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallDao.addCinemaHall(cinemaHall);
    }

    @Override
    public List<CinemaHallDTO> cinemaHallList(Integer cinemaId) {
        return cinemaHallDao.cinemaHallList(cinemaId);
    }

    @Override
    public int updateCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallDao.updateCinemaHall(cinemaHall);
    }

    @Override
    public int addCinemaHallFilm(Integer hallId, Integer filmId) {
        return cinemaHallDao.addCinemaHallFilm(hallId,filmId);
    }
}
