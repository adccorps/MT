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
     * 查询出所有电影院所有场次
     */
    List<Schedule> selectAllSchedule();

    /**
     * 根据电影院Id查询出该电影院所有电影场次
     */
    List<Schedule> selectScheduleByCinema(@Param("cinemaId") Integer cinemaId);

    /**
     * 通过电影院ID、电影ID以及时间获取该电影还未开始的场次
     */
    List<ScheduleDTO> selectScheduleByTime(@Param("cinemaId") Integer cinemaId, @Param("filmId") Integer filmId, @Param("currentTime") String currentTime);

    /**
     * 获取某电影院中电影的最低价格
     */
    BigDecimal selectMinPriceByCinema(@Param("cinemaId") Integer cinemaId);

    /**
     * 根据电影院Id和电影Id获取该电影的所有场次时间段
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


    /**
     * 根据场次ID获得场次信息
     */
    Schedule selectScheduleById(@Param("scheduleId") String scheduleId);
}
