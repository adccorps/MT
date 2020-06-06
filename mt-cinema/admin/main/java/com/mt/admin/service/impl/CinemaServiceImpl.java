package com.mt.admin.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt.admin.dao.AdminDao;
import com.mt.api.ScheduleApi;
import com.mt.pojo.Cinema;
import com.mt.admin.entity.CinemaDTO;
import com.mt.admin.service.CinemaService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
    @Resource
    AdminDao adminDao;

    @Autowired
    ScheduleApi scheduleApi;

    /**
     * 查找电影院列表
     * */
    public List<CinemaDTO> getCinemaDTOList() {
        List<CinemaDTO> cinemaDTOList;
        cinemaDTOList=adminDao.getCinemaDTOList();
        System.out.println(cinemaDTOList);
        for( int i = 0 ; i < cinemaDTOList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            CinemaDTO cinemaDTO = cinemaDTOList.get(i);
            int id=cinemaDTO.getCinemaId();
            Integer a=new Integer(id);
            Double aDouble = (Double) scheduleApi.selectMinPriceByCinema(a);
            cinemaDTO.setPrice(aDouble);
            //调用捞泉获得最低价接口
        }
        return cinemaDTOList;
    }

    /**
     * 增加电影院
     * */
    public int createCinema(Cinema cinema) {

        return adminDao.createCinema(cinema);
    }

    /**
     * 删除电影院
     * */
    public int deleteCinemaById(Integer id) {
        return adminDao.deleteCinemaById(id);
    }

    /**
     * 更新电影院
     * */
    public int updateCinema(Cinema cinema) {
        return adminDao.updateCinema(cinema);
    }

    /**
     * 根据id查电影院name
     * */
    public String getCinemaNameById(Integer id){
        return adminDao.getCinemaNameById(id);
    }
}
