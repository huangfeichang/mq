package com;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by huangfeichang on 2018/3/8 0008.
 */
@Component
@RabbitListener(queues = "topic.message")
public class comsumermqQueue1 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("topic.message  : " + hello);
    }
}
