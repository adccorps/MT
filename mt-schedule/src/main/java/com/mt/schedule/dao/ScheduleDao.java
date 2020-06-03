package com.mt.schedule.dao;

import com.mt.schedule.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    List<Schedule> selectScheduleByCinema(@Param("cinemaId") String cId);
    /**
     * 通过电影院ID以及电影ID查询场次
     * （电影院某个电影的所有场次）
     */
    List<Schedule> selectScheduleByCF(@Param("filmId") String fId, @Param("cinemaId") String cId);

    /**
     * 获取某一场次信息
     * 确定的电影院、确定的厅
     */
    Schedule selectSchedule(@Param("cinemaId") String cId,@Param("hallId") String hallId);

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
    boolean deleteScheduleById(@Param("scheduleId") String id);
}
