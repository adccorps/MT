package com.mt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageTest {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void listenerMqTest(){
        String phone = "18138770489";
        rabbitTemplate.convertAndSend("exchange.direct.message","message.verification",phone);
    }
}
