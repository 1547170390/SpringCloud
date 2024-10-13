package com.product.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列中监听消息发送者发送的消息
 */


@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public void process(Object message) {
        System.out.println("消费者收到的消息"+message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "zl.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenTopicQueue1(String message){
        System.out.println("消费者收到的消息"+message);
    }
}
