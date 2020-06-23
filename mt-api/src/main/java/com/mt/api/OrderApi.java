package com.mt.api;


import com.mt.constants.Code;
import com.mt.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Component
@FeignClient(value = "mt-server-order")
public interface OrderApi {
    /**
     * 根据顾客id获取客户订单
     */
    @GetMapping("/customer/{customerId}/orders")
    Object selectCustomerOrderInfo(@PathVariable("customerId") String customerId);

    /**
     * 根据场次号获取已选座位信息
     */
    @GetMapping("/schedule/{scheduleId}/seat")
    Object selectScheduleOrderInfo(@PathVariable("scheduleId") String scheduleId);

    /**
     * 下单前,根据场次号和座位号查询座位是否为空座
     */
    @GetMapping("/schedule/seat")
    Object selectSeatInfo(@PathVariable("scheduleId") String scheduleId, @PathVariable("seatNumber") Integer[] seatNumber);


    @GetMapping("/pay/order/{customerId}/{orderCost}/{scheduleId}/{seatNumber}")
    public void insertOrderInfo(@PathVariable("customerId") String customerId,
                                @PathVariable("orderCost") BigDecimal orderCost,
                                @PathVariable("scheduleId") String scheduleId,
                                @PathVariable("seatNumber") String seatNumber) ;

    @GetMapping("/pay/changeorder/{orderId}")
    public Object changeOrderStatus(@PathVariable("orderId") String orderId) ;




}
