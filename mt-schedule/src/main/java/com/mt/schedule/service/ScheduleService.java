package com.mt.schedule.service;

import com.mt.pojo.Schedule;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import com.mt.schedule.pojo.ScheduleDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Yeung on 2020/5/27.
 */
public interface ScheduleService {
    /**
     * 查询出所有电影院所有场次
     */
    List<Schedule> selectAllSchedule();

    /**
     * 通过电影院ID、电影ID以及时间获取该电影还未开始的场次
     */
    List<ScheduleDTO> selectScheduleByTime(Integer cinemaId, Integer filmId, String currentTime);

    /**
     * 新增场次
     */
    Object insertSchedule(List<Schedule> scheduleList);


    /**
     * 获取某电影院中电影的最低价格
     */
    BigDecimal selectMinPriceByCinema(Integer cinemaId);

    /**
     * 更新场次信息
     */
    boolean updateSchedule(Schedule schedule);

    /**
     * 删除场次
     */
    boolean deleteScheduleById(String scheduleId);

    /**
     * 根据电影院Id和电影Id获取该电影的所有场次时间段
     */
    String[] selectTime(Integer cinemaId, Integer filmId);

    /**
     * 获取电影和电影院名字，封装到OrderByScheduleIdDTO类
     */
    OrderByScheduleIdDTO selectScheduleToOrder(String scheduleId);
}
