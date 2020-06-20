package com.mt.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    Object selectSeatInfo(String scheduleId, Integer[] seatNumber);
}
