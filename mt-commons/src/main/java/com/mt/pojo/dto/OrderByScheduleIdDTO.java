package com.mt.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * Created by Yeung on 2020/6/5.
 */
@ApiModel
public class OrderByScheduleIdDTO {
    @ApiModelProperty(name = "scheduleId", value = "sId", example = "s1")
    private String scheduleId;      //场次ID

    @ApiModelProperty(name = "filmId", value = "filmId", example = "f1")
    private Integer filmId;

    @ApiModelProperty(name = "filmName", value = "filmName", example = "xxx")
    private String filmName;        //电影名字

    @ApiModelProperty(name = "cinemaName", value = "cinemaName", example = "xxx")
    private String cinemaName;     //电影院名字

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "beginTime", value = "bgTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp beginTime;   //电影开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "emdTime", value = "edTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp endTime;     //电影结束时间

    public OrderByScheduleIdDTO() {
    }

    public OrderByScheduleIdDTO(String scheduleId, Integer filmId, String filmName, String cinemaName, Timestamp beginTime, Timestamp endTime) {
        this.scheduleId = scheduleId;
        this.filmId = filmId;
        this.filmName = filmName;
        this.cinemaName = cinemaName;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
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

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        return "OrderByScheduleIdDTO{" +
                "scheduleId='" + scheduleId + '\'' +
                ", filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
