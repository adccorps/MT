package com.mt.schedule.dao;

import com.mt.pojo.Schedule;
import com.mt.schedule.pojo.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Yeung on 2020/5/27.
 */
@Mapper
@Repository
public interface ScheduleDao {
    /**
     * 查询出所有场次
     */
    List<Schedule> selectAllSchedule();

    /**
     * 查询某电影院的电影场次
     */
    List<Schedule> selectScheduleByCinema(@Param("cinemaId") Integer cinemaId);

    /**
     * 通过电影院ID、电影ID以及时间查询场次
     */
    List<ScheduleDTO> selectScheduleByTime(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId, @Param("currentTime") String currentTime);

    /**
     * 获取某电影院中电影的最低价格
     */
    BigDecimal selectMinPriceByCinema(@Param("cinemaId") Integer cinemaId);

    /**
     * 获取某电影院电影的时间段
     */
    List<Schedule> selectTime(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId);

    /**
     * 新增场次
     */
    boolean insertSchedule(@Param("schedule") Schedule schedule);

    /**
     * 更新场次信息
     */
    boolean updateSchedule(@Param("schedule") Schedule schedule);

    /**
     * 删除场次
     */
    boolean deleteScheduleById(@Param("scheduleId") String scheduleId);

    Schedule selectScheduleById(@Param("scheduleId") String scheduleId);
}
