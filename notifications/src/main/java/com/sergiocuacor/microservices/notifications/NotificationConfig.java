package com.sergiocuacor.microservices.notifications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    /* This class reads RabbitMQ exchanges, queue and routing keys from
    application.yaml and creates the RabbitMQ objects.*/
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKeys;

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
