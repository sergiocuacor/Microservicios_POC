package com.sergiocuacor.microservices.notifications;

import com.sergiocuacor.microservices.clients.notifications.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/notification")
@RestController
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {

        log.info("New notification : {}", notificationRequest);
        notificationService.send(notificationRequest);

    }

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
