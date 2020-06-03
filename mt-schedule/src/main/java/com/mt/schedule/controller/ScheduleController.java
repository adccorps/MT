package com.mt.schedule.controller;

import com.mt.schedule.pojo.Schedule;
import com.mt.schedule.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yeung on 2020/5/27.
 */
@RestController
@Api(tags = "场次管理服务")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/selectAllSchedule")
    @ApiOperation(value = "获取所有场次")
    public List<Schedule> selectAllSchedule() {
        return scheduleService.selectAllSchedule();
    }

    @RequestMapping("/selectScheduleByCF")
    @ApiOperation(value = "获取电影场次")
    public List<Schedule> selectScheduleByCF(String fId, String cId) {
        return scheduleService.selectScheduleByCF(fId, cId);
    }

    @RequestMapping("/insertSchedule")
    @ApiOperation(value = "增加场次")
    public Object insertSchedule(@RequestBody() List<Schedule> scheduleList) {
        return scheduleService.insertSchedule(scheduleList);
    }

    @RequestMapping("/updateSchedule")
    @ApiOperation(value = "更新场次信息")
    public Object updateSchedule(Schedule schedule) {
        return scheduleService.updateSchedule(schedule);
    }

    @RequestMapping("/deleteSchedule")
    @ApiOperation(value = "删除场次")
    public Object deleteScheduleById(String id) {
        return scheduleService.deleteScheduleById(id);
    }
}
