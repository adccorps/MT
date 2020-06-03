package com.mt.schedule.service;

import com.mt.schedule.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Yeung on 2020/5/27.
 */
public interface ScheduleService {
    /**
     * 查询出所有场次
     */
    List<Schedule> selectAllSchedule();

    /**
     * 通过电影院ID以及电影ID查询场次
     * （电影院某个电影的所有场次）
     */
    List<Schedule> selectScheduleByCF(String fId, String cId);

    /**
     * 新增场次
     */
    Object insertSchedule(List<Schedule> scheduleList);

    /**
     * 更新场次信息
     */
    Object updateSchedule(Schedule schedule);

    /**
     * 删除场次
     */
    Object deleteScheduleById(String id);

}
