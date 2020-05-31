package com.mt.schedule.service.impl;

import com.mt.schedule.dao.ScheduleDao;
import com.mt.schedule.pojo.Schedule;
import com.mt.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yeung on 2020/5/27.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    /**
     * 查询出所有场次
     */
    @Override
    public List<Schedule> selectAllSchedule() {
        List<Schedule> scheduleList = null;
        try{
           scheduleList = scheduleDao.selectAllSchedule();
        }catch (Exception e){
            e.printStackTrace();
        }
        return scheduleList;

    }

    /**
     * 通过电影院ID以及电影ID查询场次
     */
    @Override
    public Schedule selectScheduleById(String fId, String cId){
        Schedule schedule = new Schedule();
        if (fId != null && cId !=null){
            schedule = scheduleDao.selectScheduleById(fId,cId);
        }
        return schedule;
    }

    /**
     * 新增场次
     */
    @Override
    public boolean insertSchedule(Schedule schedule) {
        boolean flag = false;
        if (schedule != null){
            scheduleDao.insertSchedule(schedule);
            flag = true;
        }else
            flag = false;
        return flag;
    }

    /**
     * 更新场次信息
     */
    @Override
    public boolean updateSchedule(Schedule schedule) {
        boolean flag = false;
        if (schedule != null){
            scheduleDao.updateSchedule(schedule);
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    /**
     * 删除场次
     */
    @Override
    public boolean deleteScheduleById(String id) {
        boolean flag = false;
        if (id != null){
            scheduleDao.deleteScheduleById(id);
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
