package com.mt.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeificationService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendRegisterCode(String phone){
        rabbitTemplate.convertAndSend("exchange.direct.message","message.register",phone);
    }

    public void sendLoginCode(String phone){
        rabbitTemplate.convertAndSend("exchange.direct.message","message.login",phone);
    }

}
