package com.sergiocuacor.microservices.notifications;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    /*
    This class reads RabbitMQ config from
    application.yaml and creates the RabbitMQ objects.
    We also need to define 3 beans: TopicExchange, Queue and Binding
    - TopicExchange to create an exchange, the point where producers send messages in RabbitMQ.
    - Queue to create a queue where the messages will be stored
    - Binding defines HOW the messages flow from the exchange to the queue.
    ** Binding expanded:
    1. When a message arrives at an exchange, RabbitMQ uses the binding to determine which queue(s) should receive the message.
    2. The routing key of the message is compared against the routing key in the binding.
    3. If they match (according to the exchange type rules), the message is routed to the bound queue.
    */
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKeys;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }
    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }
    @Bean
    public Binding internalToNotificationBinding(){
        return BindingBuilder.bind(notificationQueue()).to(internalTopicExchange()).with(this.internalNotificationRoutingKeys);
    }

    public String getInternalExchange() {
        return internalExchange;
    }

    public void setInternalExchange(String internalExchange) {
        this.internalExchange = internalExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public void setNotificationQueue(String notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public String getInternalNotificationRoutingKeys() {
        return internalNotificationRoutingKeys;
    }

    public void setInternalNotificationRoutingKeys(String internalNotificationRoutingKeys) {
        this.internalNotificationRoutingKeys = internalNotificationRoutingKeys;
    }
}
