package com.mt.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


@ApiModel
public class OrderInfoDTO {

    @ApiModelProperty(name = "orderId", value = "orderId", example = "5415")
    private String orderId;

    @ApiModelProperty(name = "scheduleId", value = "scheduleId", example = "1")
    private String scheduleId;

    @ApiModelProperty(name = "filmName", value = "filmName", example = "猩球崛起")
    private String filmName;

    @ApiModelProperty(name = "cinemaName", value = "cinemaName", example = "中影易禾")
    private String cinemaName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "beginTime", value = "beginTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    @ApiModelProperty(name = "endTime", value = "endTime", example = "xxxx-xx-xx xx:xx:xx")
    private Timestamp endTime;

    @ApiModelProperty(name = "number", value = "number", example = "1")
    private Integer number;


    public OrderInfoDTO() {

    }

    ;

    //重写一个构造方法把需要的值传入
    public OrderInfoDTO(Order order, OrderByScheduleIdDTO orderByScheduleIdDTO) {
        this.orderId = order.getOrderId();
        this.scheduleId = order.getScheduleId();
        this.filmName = orderByScheduleIdDTO.getFilmName();
        this.cinemaName = orderByScheduleIdDTO.getCinemaName();
        this.beginTime = orderByScheduleIdDTO.getBeginTime();
        this.endTime = orderByScheduleIdDTO.getEndTime();
        //order里面拿到座位字符串,分隔后座位数量
        // == "1,2,3"-->{1,2,3}.length
        String num = order.getSeatNumber();
        String n[] = num.split(",");
        int num1= n.length;
        this.number = num1;



    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "orderId='" + orderId + '\'' +
                ", scheduleId='" + scheduleId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", number=" + number +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    ;

}