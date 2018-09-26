package com.hitol.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收
 * @author hitol
 * @date 2018/9/26 下午8:11
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver : " + hello);
    }
}
