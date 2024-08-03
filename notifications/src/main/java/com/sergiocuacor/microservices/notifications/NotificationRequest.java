package com.sergiocuacor.microservices.notifications;

public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;

    public NotificationRequest() {
    }

    public NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
        this.toCustomerId = toCustomerId;
        this.toCustomerEmail = toCustomerEmail;
        this.message = message;
    }



    public Integer getToCustomerId() {
        return toCustomerId;
    }

    public String getToCustomerEmail() {
        return toCustomerEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setToCustomerId(Integer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public void setToCustomerEmail(String toCustomerEmail) {
        this.toCustomerEmail = toCustomerEmail;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    @Override
    public String toString() {
        return "Notification{" +
                "toCustomerId=" + toCustomerId +
                ", toCustomerEmail='" + toCustomerEmail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
