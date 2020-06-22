package com.mt.schedule.service.impl;

import com.mt.api.CinemaAdminApi;
import com.mt.api.FilmApi;
import com.mt.constants.Code;
import com.mt.exception.ResultException;
import com.mt.pojo.dto.FilmInfoDTO;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import com.mt.schedule.dao.ScheduleDao;
import com.mt.pojo.dto.InsertJudgmentDTO;
import com.mt.pojo.Schedule;
import com.mt.pojo.dto.ScheduleDTO;
import com.mt.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Yeung on 2020/5/27.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private FilmApi filmApi;
    @Autowired
    private CinemaAdminApi cinemaAdminApi;
    /**
     * 查询出所有电影院所有场次
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
     * 通过电影院ID、电影ID以及时间获取该电影还未开始的场次
     */
    @Override
    public List<ScheduleDTO> selectScheduleByTime(Integer cinemaId, Integer filmId, String currentTime) {
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        if (cinemaId != null && filmId != null && currentTime != null) {
            scheduleDTOS = scheduleDao.selectScheduleByTime(cinemaId, filmId, currentTime);
        } else throw new ResultException(Code.NOT_FOUND);
        return scheduleDTOS;
    }

    /**
     * 新增场次
     */
    @Override
    public Object insertSchedule(List<Schedule> scheduleList) {
        List<Schedule> checkSchedule;     //查询数据库数据是否存在
        Schedule scheduleData;            //要插入的新数据
        //数据库存在的时间段
        Date oldBeginTime;
        Date oldEndTime;
        //需要重新插入的时间段
        Date beginTime;
        Date endTime;
        int failCount = 0;
        int successCount = 0;
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
                    flag = false;
                    failCount++;
                    break;
                }
                oldBeginTime = checkSchedule.get(j).getBeginTime();
                oldEndTime = checkSchedule.get(j).getEndTime();
                //判断时间是否冲突
                if (!(beginTime.after(oldEndTime) || endTime.before(oldBeginTime))) {
                    flag = false;
                    failCount++;
                }
            }
            if (flag) {
                if (scheduleData != null) {
                    scheduleDao.insertSchedule(scheduleData);
                    successCount++;
                } else throw new ResultException(Code.NOT_FOUND);
            }
        }
        InsertJudgmentDTO insertJudgmentDTO = new InsertJudgmentDTO(failCount, successCount);
        return insertJudgmentDTO;
    }


    /**
     * 获取某电影院中电影的最低价格
     */
    @Override
    public BigDecimal selectMinPriceByCinema(Integer cinemaId) {
        BigDecimal bigDecimal;
        if (cinemaId != null) {
            bigDecimal = scheduleDao.selectMinPriceByCinema(cinemaId);
        } else throw new ResultException(Code.NOT_FOUND);
        return bigDecimal;
    }

    /**
     * 更新场次信息
     */
    @Override
    public boolean updateSchedule(Schedule schedule) {
        List<Schedule> checkSchedule;     //查询数据库数据是否存在
        int cinemaId;
        //数据库存在的时间段
        Date oldBeginTime;
        Date oldEndTime;
        //需要重新插入的时间段
        Date beginTime;
        Date endTime;
        boolean flag = true;
        String errorMessage = ""; //错误信息
        if (schedule.getCinemaId() == null) {
            cinemaId = scheduleDao.selectScheduleById(schedule.getScheduleId()).getCinemaId();
        } else {
            cinemaId = schedule.getCinemaId();
        }
        checkSchedule = scheduleDao.selectScheduleByCinema(cinemaId);
        if (schedule.getHallId() != null || (schedule.getBeginTime() != null && schedule.getEndTime() != null)) {
            for (int i = 0; i < checkSchedule.size(); i++) {
                if (schedule.getHallId() != null) {
                    //判断厅是否存在
                    if (checkSchedule.get(i).getHallId().equals(schedule.getHallId())) {
                        flag = false;
                        errorMessage = "Hall Conflict";
                        break;
                    }
                }
                beginTime = schedule.getBeginTime();
                endTime = schedule.getEndTime();
                //判断时间是否冲突
                if (beginTime != null && endTime != null) {
                    oldBeginTime = checkSchedule.get(i).getBeginTime();
                    oldEndTime = checkSchedule.get(i).getEndTime();
                    if (!(beginTime.after(oldEndTime) || endTime.before(oldBeginTime))) {
                        flag = false;
                        errorMessage = "Time Conflict";
                    }
                }
            }
        }

        if (flag) {
            if (schedule != null) {
                scheduleDao.updateSchedule(schedule);
            } else throw new ResultException(Code.NOT_FOUND);
        } else throw new ResultException(errorMessage);
        return true;
    }

    /**
     * 删除场次
     */
    @Override
    public boolean deleteScheduleById(String scheduleId) {
        if (scheduleId != null) {
            scheduleDao.deleteScheduleById(scheduleId);
        } else throw new ResultException(Code.NOT_FOUND);
        return true;
    }


    /**
     * 根据电影院Id和电影Id获取该电影的所有场次时间段
     */
    @Override
    public String[] selectTime(Integer cinemaId, Integer filmId) {
        List<Schedule> scheduleList = new ArrayList<>();
        if (cinemaId != null && filmId != null) {
            scheduleList = scheduleDao.selectTime(cinemaId, filmId);
        } else throw new ResultException(Code.NOT_FOUND);
        String[] time = new String[scheduleList.size()];
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        for (int i = 0; i < scheduleList.size(); i++) {
            time[i] = timeFormat.format(scheduleList.get(i).getBeginTime()) + "," + timeFormat.format(scheduleList.get(i).getEndTime());
        }
        return time;
    }

    /**
     * 获取电影和电影院名字，封装到OrderByScheduleIdDTO类
     */
    @Override
    public OrderByScheduleIdDTO selectScheduleToOrder(String scheduleId) {
        Schedule schedule = scheduleDao.selectScheduleById(scheduleId);
        HashMap<FilmInfoDTO,String> filmDTOById = (HashMap<FilmInfoDTO, String>) filmApi.getFilmDTOById(schedule.getFilmId());
        String filmName = filmDTOById.get("filmName");
        String cinemaName =  cinemaAdminApi.getCinemaNameById(schedule.getCinemaId()) ;
        OrderByScheduleIdDTO orderByScheduleIdDTO = new OrderByScheduleIdDTO(schedule.getScheduleId(),filmName,cinemaName,schedule.getBeginTime(),schedule.getEndTime());
        return orderByScheduleIdDTO;
    }

}
