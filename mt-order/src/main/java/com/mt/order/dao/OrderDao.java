package com.mt.order.dao;

import com.mt.order.pojo.Order;
import com.mt.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface OrderDao {
    /**
     * 根据顾客ID查询出订单
     */
    List<Order> selectCustomerOrderInfo(@Param("customerId") String customerId);


    /**
     * 根据场次号查询出订单
     */
    List<Order> selectScheduleOrderInfo(@Param("scheduleId") String scheduleId);

    /**
     * 数据数量
     * @return
     */
    int CountOrderInfo();

    /**
     * 新增场次
     */
    boolean insertOrderInfo(@Param("order") Order order);

    /**
     * 更改当前订单status
     */
    Boolean changeOrderStatus(@Param("orderId")String orderId);
    /**
     * 下单前,根据场次号和座位号查询座位是否为空座
     */
   // List<Order> selectSeatInfo(@Param("scheduleId") String scheduleId,@Param("seatNumber") String seatNumber);
}
