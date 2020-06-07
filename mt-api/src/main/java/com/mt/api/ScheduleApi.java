package com.mt.api;


import com.mt.pojo.Schedule;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Component
@FeignClient(value = "mt-server-schedule")
public interface ScheduleApi {

    /**
     * 通过电影院ID、电影ID以及时间查询该电影还未开始的场次
     * @return List<ScheduleDTO>
     */
    @GetMapping("/cinema/{cinemaId}/film/{filmId}/schedules")
    Object selectScheduleByTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId, @RequestParam("currentTime") String currentTime);

    /**
     * 电影院排片上传
     * @return
     */
    @PostMapping("/schedule")
    Object insertSchedule(@RequestBody() List<Schedule> scheduleList);

    /**
     * 电影院获取最低价格
     * @return BigDecimal
     */
    @GetMapping("/cinema/{cinemaId}/price")
    Object selectMinPriceByCinema(@PathVariable("cinemaId") Integer cinemaId);


    /**
     * 根据电影院Id和电影Id获取该电影的所有场次时间段
     * @return String[]
     */
    @GetMapping("/cinema/{cinemaId}/film/{filmId}/date")
    Object selectTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId);

    /**
     * 获取电影和电影院名字，封装到OrderByScheduleIdDTO类
     * 镇东用
     */
    @GetMapping("/selectScheduleToOrder")
    OrderByScheduleIdDTO selectScheduleToOrder(@RequestParam("scheduleId") String scheduleId);
}
