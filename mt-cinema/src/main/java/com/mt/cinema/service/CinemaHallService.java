package com.mt.cinema.service;

import com.mt.cinema.entity.CinemaHallDTO;
import com.mt.pojo.CinemaHall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaHallService {
    /**
     电影厅增加
     */
    int addCinemaHall(CinemaHall cinemaHall);
    /**
     电影厅列表
     */
    List<CinemaHallDTO> cinemaHallList(Integer cinemaId);
    /**
     电影厅修改
     */
    int updateCinemaHall(CinemaHall cinemaHall);

}
