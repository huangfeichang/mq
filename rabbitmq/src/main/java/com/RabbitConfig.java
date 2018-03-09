package com;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huangfeichang on 2018/3/8 0008.
 */
@Configuration
public class RabbitConfig {
    private static final String MESSAGE = "topic.message";
    private static final String MESSAGES = "topic.messages";
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue messageQueue() {
        return new Queue(RabbitConfig.MESSAGE);
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue(RabbitConfig.MESSAGES);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    // 【topic.message队列】路由key的匹配模式topic.message
    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(messageQueue()).to(exchange()).with("topic.message");
    }

    // 【topic.messages队列】路由key的匹配模式topic.#
    @Bean
    public Binding bindingExchangeMessages() {
        return BindingBuilder.bind(messagesQueue()).to(exchange()).with("topic.#");
    }
}
