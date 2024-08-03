package com.sergiocuacor.microservices.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.sergiocuacor.microservices.clients"
)
public class NotificationsApplication {
    public static void main(String[] args){
        SpringApplication.run(NotificationsApplication.class, args);
    }
}
