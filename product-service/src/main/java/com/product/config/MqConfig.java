package com.product.config;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@AllArgsConstructor
public class MqConfig {

    @Bean
    public MessageConverter MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
