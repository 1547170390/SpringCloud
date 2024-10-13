package com.product.listener;

import com.zl.api.client.OrderClient;
import com.zl.api.dto.OrderInfo;
import jakarta.annotation.Resource;
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

    @Resource
    private OrderClient orderClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "zl.queue",durable = "true"),
            exchange = @Exchange(name = "zl.topic",type = ExchangeTypes.TOPIC),
            key = "error"
    ))
    public void process(Integer id) {
        OrderInfo orderInfo = orderClient.queryOrderById(id);
    }
}
