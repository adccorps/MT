package com.mt.order.service;

import com.mt.order.pojo.OrderInfoDTO;
import com.mt.order.pojo.OrderScheduleInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    /**
     * 根据顾客ID查询出订单
     */
    List<OrderInfoDTO> selectCustomerOrderInfo(@Param("customerId") String customerId);


    /**
     * 根据场次号查询出订单
     */
    List<OrderScheduleInfoDTO> selectScheduleOrderInfo(@Param("scheduleId") String scheduleId);


    /**
     * 下单前,根据场次号和座位号查询座位是否为空座
     */
    boolean selectSeatInfo(@Param("scheduleId") String scheduleId,@Param("seatNumber") Integer[] seatNumber);
}

