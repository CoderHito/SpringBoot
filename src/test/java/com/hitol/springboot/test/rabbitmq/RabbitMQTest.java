package com.hitol.springboot.test.rabbitmq;

import com.hitol.springboot.rabbitmq.Sender;
import com.hitol.springboot.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * RabbitMQ 单元测试
 *
 * @author hitol
 * @date 2018/9/26 下午7:40
 */
public class RabbitMQTest extends BaseTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendTest() {
        sender.send();
    }
}
