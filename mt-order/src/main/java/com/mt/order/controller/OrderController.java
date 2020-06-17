package com.mt.order.controller;


import com.mt.constants.Code;
import com.mt.order.service.OrderService;
import com.mt.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "订单管理服务")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/customer/{customerId}/orders")
    @ApiOperation(value = "根据顾客id获取客户订单")
    public Object selectCustomerOrderInfo(@PathVariable("customerId") String customerId) {
        Result result = new Result(Code.OK, orderService.selectCustomerOrderInfo(customerId));
//        Result result = new Result(Code.OK, "xxxx");
//        Result result = new Result(Code.OK, true/false);
        return result;

    }

    @GetMapping("/schedule/{scheduleId}/seat")
    @ApiOperation(value = "根据场次号获取已选座位信息")
    public Object selectScheduleOrderInfo(@PathVariable("scheduleId")  String scheduleId) {
        Result result = new Result(Code.OK, orderService.selectScheduleOrderInfo(scheduleId));

        return result;

    }

    @GetMapping("/schedule/seat")
    @ApiOperation(value = "下单前,根据场次号和座位号查询座位是否为空座")
    public Object selectSeatInfo(String scheduleId,Integer[] seatNumber) {
        Result result = new Result(Code.OK, orderService.selectSeatInfo(scheduleId,seatNumber));

        return result;

    }

}
