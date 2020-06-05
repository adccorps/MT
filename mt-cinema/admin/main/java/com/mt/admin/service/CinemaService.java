package com.mt.admin.service;

import com.mt.pojo.Cinema;
import com.mt.admin.entity.CinemaDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaService {
    /**
     * 查找电影院列表
     * */
    List<CinemaDTO> getCinemaDTOList();

    /**
     * 增加电影院
     * */
     int createCinema(Cinema cinema);
    /**
     * 删除电影院
     * */
     int deleteCinemaById(Integer id);
    /**
     * 修改电影院
     * */
     int updateCinema(Cinema cinema);
}
