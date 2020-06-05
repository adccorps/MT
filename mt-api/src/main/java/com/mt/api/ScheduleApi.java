package com.mt.api;


import com.mt.pojo.Schedule;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Component
@FeignClient(value = "mt-server-schedule")
public interface ScheduleApi {

    /**
     * 获取具体场次信息列表
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
     * 获取电影日期安排
     * @return String[]
     */
    @GetMapping("/cinema/{cinemaId}/film/{filmId}/date")
    Object selectTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId);
}
