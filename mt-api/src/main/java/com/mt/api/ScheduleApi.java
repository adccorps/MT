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

    @GetMapping("/schedules")
    Object selectScheduleByTime(@RequestParam("filmId") Integer filmId, @RequestParam("cinemaId") Integer cinemaId, @RequestParam("currentTime") String currentTime);

    @PostMapping("/schedule")
    Object insertSchedule(@RequestBody() List<Schedule> scheduleList);

    @GetMapping("/cinema/{cinemaId}/price")
    Object selectMinPriceByCinema(@PathVariable("cinemaId") Integer cinemaId);

    @GetMapping("/cinema/{cinemaId}/film/{filmId}/date")
    Object selectTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId);
}
