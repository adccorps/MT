package com.mt.schedule.service;

import com.mt.pojo.Schedule;
import com.mt.schedule.pojo.ScheduleDTO;

import java.math.BigDecimal;
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
     * 通过电影院ID、电影ID以及时间查询场次
     */
    List<ScheduleDTO> selectScheduleByTime(String fId, String cId, String currentTime);

    /**
     * 新增场次
     */
    Object insertSchedule(List<Schedule> scheduleList);


    /**
     * 获取某电影院中电影的最低价格
     */
    BigDecimal selectMinPriceByCinema(String cId);

    /**
     * 更新场次信息
     */
    boolean updateSchedule(Schedule schedule);

    /**
     * 删除场次
     */
    boolean deleteScheduleById(String id);

    /**
     * 获取某电影院电影的时间段
     */
    String[] selectTime(String cId, String fId);
}
