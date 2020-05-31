package com.mt.schedule.controller;

import com.mt.schedule.pojo.Schedule;
import com.mt.schedule.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/selectSchedule")
    @ApiOperation(value = "获取场次")
    public Schedule selectScheduleById(String fId, String cId) {
        return scheduleService.selectScheduleById(fId, cId);
    }

    @RequestMapping("/insertSchedule")
    @ApiOperation(value = "增加场次")
    public boolean insertSchedule(Schedule schedule){
        return scheduleService.insertSchedule(schedule);
    }

    @RequestMapping("/updateSchedule")
    @ApiOperation(value = "更新场次信息")
    public boolean updateSchedule(Schedule schedule){
        return scheduleService.updateSchedule(schedule);
    }

    @RequestMapping("/deleteSchedule")
    @ApiOperation(value = "删除场次")
    public boolean deleteScheduleById(String id) {
        return scheduleService.deleteScheduleById(id);
    }
}
