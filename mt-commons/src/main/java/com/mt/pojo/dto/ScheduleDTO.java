package com.mt.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Yeung on 2020/6/3.
 */
@ApiModel
public class ScheduleDTO {
    @ApiModelProperty(name = "scheduleId", value = "scheduleId", example = "s1")
    private String scheduleId;   //场次ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "beginTime", value = "beginTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp beginTime;   //电影开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "emdTime", value = "emdTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp endTime;     //电影结束时间

    @ApiModelProperty(name="hallName",value="hallName",example="厅1")
    private String hallName;

    @ApiModelProperty(name = "filmPrice", value = "filmPrice", example = "100.0")
    private BigDecimal filmPrice;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String scheduleId, Timestamp beginTime, Timestamp endTime, String hallName, BigDecimal filmPrice) {
        this.scheduleId = scheduleId;
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
        return "ScheduleDTO{" +
                "scheduleId='" + scheduleId + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", hallName='" + hallName + '\'' +
                ", filmPrice=" + filmPrice +
                '}';
    }
}
