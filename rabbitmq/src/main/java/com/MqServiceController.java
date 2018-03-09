package com;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangfeichang on 2018/3/8 0008.
 */
@RestController
@RequestMapping(value = "mqServiceController/")
public class MqServiceController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(String msg) {
        amqpTemplate.convertAndSend("exchange",msg, "dwanakas");
        return "asxsxa";
    }
}
