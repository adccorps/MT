package com.mt.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.sql.Timestamp;
import java.util.Arrays;


@ApiModel
public class OrderScheduleInfoDTO {

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


    @ApiModelProperty(name = "seat", value = "seat", example = "1,2")
    private String[] seat;

    public OrderScheduleInfoDTO(String filmName, String cinemaName, Timestamp beginTime, Timestamp endTime, String[] seat) {
        this.filmName = filmName;
        this.cinemaName = cinemaName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.seat = seat;
    }

    public OrderScheduleInfoDTO(Order order, OrderByScheduleIdDTO orderByScheduleIdDTO) {
        this.filmName = orderByScheduleIdDTO.getFilmName();
        this.cinemaName = orderByScheduleIdDTO.getCinemaName();
        this.beginTime = orderByScheduleIdDTO.getBeginTime();
        this.endTime = orderByScheduleIdDTO.getEndTime();

        String integer[] =new String[1000];
        //拿到一条订单的座位号字符串 "12,13"
        String num = order.getSeatNumber();
        // 分隔字符串,得到具体座位号码 12 13
        integer = num.split(",");
        // 添加座位号-->返回数组

        this.seat = integer;
    }


    @Override
    public String toString() {
        return "OrderDTO{" +
                "filmName='" + filmName + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", seat=" + Arrays.toString(seat) +
                '}';
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

    public String[] getSeat() {
        return seat;
    }

    public void setSeat(String[] seat) {
        this.seat = seat;
    }
}
