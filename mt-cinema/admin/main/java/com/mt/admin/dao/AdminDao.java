package com.mt.admin.dao;

import com.mt.pojo.Cinema;
import com.mt.admin.entity.CinemaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminDao {
    /**
     * 对电影院的增删改查
     * */
        /**
         * 增加电影院
         * */
         int createCinema(Cinema cinema);
        /**
         * 删除电影院
         * */
         int deleteCinemaById(@Param("cinemaId") Integer id);
        /**
         * 修改电影院
         * */
         int updateCinema(Cinema cinema);
        /**
         * 查找电影院列表
         * */
        List<CinemaDTO> getCinemaDTOList();
}
