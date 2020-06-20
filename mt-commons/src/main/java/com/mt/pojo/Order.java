package com.mt.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private String orderId;
    private Timestamp createTime;
    private String customerId;
    private BigDecimal orderCost;
    private BigDecimal realCost;
    private Integer status;
    private String scheduleId;
    private String seatNumber;


    public Order(String orderId, Timestamp createTime, String customerId, BigDecimal orderCost, BigDecimal realCost, Integer status, String scheduleId, String seatNumber) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.customerId = customerId;
        this.orderCost = orderCost;
        this.realCost = realCost;
        this.status = status;
        this.scheduleId = scheduleId;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", customerId='" + customerId + '\'' +
                ", orderCost=" + orderCost +
                ", realCost=" + realCost +
                ", status=" + status +
                ", scheduleId='" + scheduleId + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public BigDecimal getRealCost() {
        return realCost;
    }

    public void setRealCost(BigDecimal realCost) {
        this.realCost = realCost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
