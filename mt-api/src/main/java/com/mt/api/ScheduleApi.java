package com.mt.api;

import com.mt.schedule.pojo.Schedule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Yeung on 2020/6/3.
 */
@Component
@FeignClient(value = "mt-server-schedule")
public interface ScheduleApi {

    @RequestMapping("/selectScheduleByTime")
    public Object selectScheduleByTime(String fId, String cId, String currentTime);

    @RequestMapping("/insertSchedule")
    public Object insertSchedule(@RequestBody() List<Schedule> scheduleList);

    @RequestMapping("/selectMinPrice")
    public Object selectMinPriceByCinema(String cId);
}
