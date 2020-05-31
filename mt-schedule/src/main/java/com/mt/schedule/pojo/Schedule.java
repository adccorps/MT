package com.mt.schedule.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Yeung on 2020/5/27.
 */
@ApiModel
public class Schedule {
    @ApiModelProperty(name = "scheduleId", value = "sId", example = "s1")
    public String scheduleId;   //场次ID
    @ApiModelProperty(name = "filmId", value = "fId", example = "f1")
    public int filmId;       //电影ID
    @ApiModelProperty(name = "cinemaId", value = "cId", example = "c1")
    public int cinemaId;     //电影院ID
    @ApiModelProperty(name = "beginTime", value = "bgTime", example = "xxxx-xx-xx xx:xx:xx")
    public Date beginTime;   //电影开始时间
    @ApiModelProperty(name = "emdTime", value = "edTime", example = "xxxx-xx-xx xx:xx:xx")
    public Date endTime;     //电影结束时间
    @ApiModelProperty(name = "hallId", value = "hName", example = "h1")
    public String hallName;       //厅名字
    @ApiModelProperty(name = "filmPrice", value = "fPrice", example = "100.0")
    public BigDecimal filmPrice;

    public Schedule() {
    }

    public Schedule(String scheduleId, int filmId, int cinemaId, Date beginTime, Date endTime, String hallName, BigDecimal filmPrice) {
        this.scheduleId = scheduleId;
        this.filmId = filmId;
        this.cinemaId = cinemaId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.hallName = hallName;
        this.filmPrice = filmPrice;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public BigDecimal getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(BigDecimal filmPrice) {
        this.filmPrice = filmPrice;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId='" + scheduleId + '\'' +
                ", filmId=" + filmId +
                ", cinemaId=" + cinemaId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", hallName='" + hallName + '\'' +
                ", filmPrice=" + filmPrice +
                '}';
    }
}
