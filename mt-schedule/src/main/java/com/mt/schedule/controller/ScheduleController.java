package com.mt.schedule.controller;

import com.mt.constants.Code;
import com.mt.pojo.Schedule;
import com.mt.schedule.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.mt.pojo.Result;
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
    public Object selectAllSchedule() {
        Result result = new Result(Code.OK,scheduleService.selectAllSchedule());
        return result;
    }

    @RequestMapping("/selectScheduleByTime")
    @ApiOperation(value = "获取电影场次")
    public Object selectScheduleByTime(String fId, String cId, String currentTime) {
        Result result = new Result(Code.OK,scheduleService.selectScheduleByTime(fId, cId,currentTime));
        return result;
    }

    @RequestMapping("/insertSchedule")
    @ApiOperation(value = "增加场次")
    public Object insertSchedule(@RequestBody() List<Schedule> scheduleList) {
        Result result = new Result(Code.OK,scheduleService.insertSchedule(scheduleList));
        return result;
    }

    @RequestMapping("/updateSchedule")
    @ApiOperation(value = "更新场次信息")
    public Object updateSchedule(@RequestBody() Schedule schedule) {
        Result result = new Result(Code.OK,scheduleService.updateSchedule(schedule));
        return result;
    }

    @RequestMapping("/deleteSchedule")
    @ApiOperation(value = "删除场次")
    public Object deleteScheduleById(String id) {
        Result result = new Result(Code.OK,scheduleService.deleteScheduleById(id));
        return result;
    }

    @RequestMapping("/selectMinPrice")
    @ApiOperation(value = "获取最低价格")
    public Object selectMinPriceByCinema(String cId){
        Result result = new Result(Code.OK,scheduleService.selectMinPriceByCinema(cId));
        return result;
    }

    @RequestMapping("/selectTime")
    @ApiOperation(value = "获取电影时间段")
    public Object selectTime(String cId,String fId){
        Result result = new Result(Code.OK,scheduleService.selectTime(cId,fId));
        return result;
    }
}
