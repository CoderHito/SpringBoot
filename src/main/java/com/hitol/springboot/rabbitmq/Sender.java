package com.hitol.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送
 * @author hitol
 * @date 2018/9/26 下午8:09
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}

