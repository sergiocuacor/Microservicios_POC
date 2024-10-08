package com.sergiocuacor.microservices.notifications;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;

    public Notification() {

    }

    public Notification(Integer notificationId, Integer toCustomerId, String toCustomerEmail, String sender, String message, LocalDateTime sentAt) {
        this.notificationId = notificationId;
        this.toCustomerId = toCustomerId;
        this.toCustomerEmail = toCustomerEmail;
        this.sender = sender;
        this.message = message;
        this.sentAt = sentAt;
    }

    private Notification(NotificationBuilder builder) {
        this.notificationId = builder.notificationId;
        this.toCustomerId = builder.toCustomerId;
        this.toCustomerEmail = builder.toCustomerEmail;
        this.sender = builder.sender;
        this.message = builder.message;
        this.sentAt = builder.sentAt;

    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(Integer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", toCustomerId=" + toCustomerId +
                ", toCustomerEmail='" + toCustomerEmail + '\'' +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", setdAt=" + sentAt +
                '}';
    }

    public static NotificationBuilder builder() {
        return new NotificationBuilder();
    }

    public static class NotificationBuilder {
        private Integer notificationId;
        private Integer toCustomerId;
        private String toCustomerEmail;
        private String sender;
        private String message;
        private LocalDateTime sentAt;

        public NotificationBuilder() {

        }

        public NotificationBuilder notificationId(Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public NotificationBuilder toCustomerId(Integer toCustomerId) {
            this.toCustomerId = toCustomerId;
            return this;
        }

        public NotificationBuilder toCustomerEmail(String toCustomerEmail) {
            this.toCustomerEmail = toCustomerEmail;
            return this;
        }

        public NotificationBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public NotificationBuilder message(String message) {
            this.message = message;
            return this;
        }

        public NotificationBuilder sentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }

    }
}
