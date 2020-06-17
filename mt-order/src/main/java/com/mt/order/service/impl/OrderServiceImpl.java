package com.mt.order.service.impl;

import com.mt.api.ScheduleApi;
import com.mt.order.dao.OrderDao;
import com.mt.order.pojo.Order;
import com.mt.order.pojo.OrderInfoDTO;
import com.mt.order.pojo.OrderScheduleInfoDTO;
import com.mt.order.service.OrderService;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ScheduleApi scheduleApi;

    @Override
    public List<OrderInfoDTO> selectCustomerOrderInfo(String customerId) {
        List<OrderInfoDTO> orderInfoDTOS = new ArrayList<>();

        try {
            List<Order> orderList = orderDao.selectCustomerOrderInfo(customerId);

            for (Order order : orderList) {
                //外部API
                OrderByScheduleIdDTO orderByScheduleIdDTO = scheduleApi.selectScheduleToOrder(order.getScheduleId());
                //
                orderInfoDTOS.add(new OrderInfoDTO(order, orderByScheduleIdDTO));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfoDTOS;

    }

    @Override
    public List<OrderScheduleInfoDTO> selectScheduleOrderInfo(String scheduleId) {
        List<OrderScheduleInfoDTO> orderScheduleInfoDTOS = new ArrayList<>();

        try {
            List<Order> list = orderDao.selectScheduleOrderInfo(scheduleId);

            for (Order order : list) {
                //外部API
                OrderByScheduleIdDTO orderByScheduleIdDTO = scheduleApi.selectScheduleToOrder(order.getScheduleId());

                orderScheduleInfoDTOS.add(new OrderScheduleInfoDTO(order, orderByScheduleIdDTO));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return orderScheduleInfoDTOS;
    }

    @Override
    public boolean selectSeatInfo(String scheduleId, Integer[] seatNumber) {

        List<OrderScheduleInfoDTO> orderScheduleInfoDTOS = new ArrayList<>();

        try {
            List<Order> list = orderDao.selectScheduleOrderInfo(scheduleId);
            Set<String> set = new HashSet<>();
            for (Order order : list) {

                String oldNum = order.getSeatNumber();

                String[] split = oldNum.split(",");
                for (int i = 0; i < split.length; i++) {
                    set.add(split[i]);
                }

            }
            for (int i = 0; i <seatNumber.length; i++) {
                if(set.contains(seatNumber[i].toString())){
                    return false;
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }


}

    /*    public Integer[] xxx(int scheduleId) {
           Integer[] integers = new Integer[];
        list<order> list = dao.selectScheduleOrderInfo;
        for (Order order : list) {
            //拿到一条订单的座位号字符串
             String num = order.getSeatNumber();
              // 分隔字符串,得到具体座位号码
        String n[] = num.split(",");
            // 添加座位号-->返回数组

        }
        return 返回数组;*/
//方法体返回类型 布尔型
//for循环里面查出表信息
// 在前端拿到数组
//split分开拿到的数组
//将数据库中的座位信息字符串变为数组
//对比



