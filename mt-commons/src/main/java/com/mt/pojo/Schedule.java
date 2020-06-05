package com.mt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Yeung on 2020/5/27.
 */
@ApiModel
public class Schedule {
    @ApiModelProperty(name = "scheduleId", value = "scheduleId", example = "s1")
    private String scheduleId;   //场次ID

    @ApiModelProperty(name = "filmId", value = "filmId", example = "f1")
    private Integer filmId;       //电影ID

    @ApiModelProperty(name = "cinemaId", value = "cinemaId", example = "c1")
    private Integer cinemaId;     //电影院ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "beginTime", value = "beginTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp beginTime;   //电影开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "emdTime", value = "emdTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp endTime;     //电影结束时间

    @ApiModelProperty(name = "hallId", value = "hallId", example = "h1")
    private Integer hallId;       //厅ID

    @ApiModelProperty(name = "filmPrice", value = "filmPrice", example = "100.0")
    private BigDecimal filmPrice;

    public Schedule() {
    }

    public Schedule(String scheduleId, Integer filmId, Integer cinemaId, Timestamp beginTime, Timestamp endTime, Integer hallId, BigDecimal filmPrice) {
        this.scheduleId = scheduleId;
        this.filmId = filmId;
        this.cinemaId = cinemaId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.hallId = hallId;
        this.filmPrice = filmPrice;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
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
                ", hallId=" + hallId +
                ", filmPrice=" + filmPrice +
                '}';
    }
}
