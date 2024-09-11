package com.sergiocuacor.microservices.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    private static final Logger log = LoggerFactory.getLogger(RabbitMQMessageProducer.class);

    public RabbitMQMessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publish(Object payload, String exchange, String routingKey){
        log.info("Publishing message to exchange {} with routingKey {}...", exchange, routingKey);
        amqpTemplate.convertAndSend(exchange,routingKey, payload);
        log.info("Published message to exchange {} with routingKey {}", exchange, routingKey);

    }

}
