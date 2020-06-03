package com.mt.schedule.service.impl;

import com.mt.schedule.dao.ScheduleDao;
import com.mt.schedule.pojo.Schedule;
import com.mt.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        try {
            scheduleList = scheduleDao.selectAllSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;

    }

    /**
     * 通过电影院ID以及电影ID查询场次
     * （电影院某个电影的所有场次）
     */
    @Override
    public List<Schedule> selectScheduleByCF(String fId, String cId) {
        List<Schedule> scheduleList = new ArrayList<>();
        if (fId != null && cId != null) {
            scheduleList = scheduleDao.selectScheduleByCF(fId, cId);
        }
        for (int i = 0; i < scheduleList.size(); i++) {
            scheduleList.get(i).setFilmId(null);
            scheduleList.get(i).setCinemaId(null);
        }
        return scheduleList;
    }

    /**
     * 新增场次
     */
    @Override
    public Object insertSchedule(List<Schedule> scheduleList) {
        List<Schedule> checkSchedule;     //查询数据库数据是否存在
        Schedule scheduleData;            //要插入的新数据
        Date oldBeginTime;
        Date oldEndTime;
        Date beginTime;
        Date endTime;
        int failCount = 0;
        int successCount= 0;
        boolean flag = true;
        for (int i = 0; i < scheduleList.size(); i++) {
            scheduleData = scheduleList.get(i);
            beginTime = scheduleData.getBeginTime();
            endTime = scheduleData.getEndTime();
            checkSchedule = scheduleDao.selectScheduleByCinema(scheduleData.getCinemaId());
            flag = true;
            for (int j = 0; j < checkSchedule.size(); j++) {
                //判断厅是否存在
                if (checkSchedule.get(j).getHallId().equals(scheduleData.getHallId())) {
                    flag = false;  //待修改。返回result 厅已存在，请重试其他厅。
                    failCount++;
                    break;
                }
                oldBeginTime = checkSchedule.get(j).getBeginTime();
                oldEndTime = checkSchedule.get(j).getEndTime();
                //判断时间是否冲突
                if (!(beginTime.after(oldEndTime) || endTime.before(oldBeginTime))) {
                    flag = false; //待修改。返回时间冲突，请重新选择时间。
                    failCount++;
                }
            }
            if (flag) {
                if (scheduleData != null) {
                    scheduleDao.insertSchedule(scheduleData);
                    successCount++;
                }
            }
        }
        System.out.println("失败："+failCount);
        System.out.println("成功："+successCount);
        //待完善
        return flag;
    }

    /**
     * 更新场次信息
     */
    @Override
    public Object updateSchedule(Schedule schedule) {
        boolean flag = false;
        if (schedule != null) {
            scheduleDao.updateSchedule(schedule);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 删除场次
     */
    @Override
    public Object deleteScheduleById(String id) {
        boolean flag = false;
        if (id != null) {
            scheduleDao.deleteScheduleById(id);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

}
