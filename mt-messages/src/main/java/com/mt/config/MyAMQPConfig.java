package com.mt.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAMQPConfig {

    /**
     * 消息转换器MessageConverter默认使用的是jdk的序列化器，序列化后的结果在RabbitMq服务器中不好查看
     * 更改消息转换器的序列化为Json
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
