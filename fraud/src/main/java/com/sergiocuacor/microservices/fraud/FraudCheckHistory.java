package com.sergiocuacor.microservices.fraud;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isFraudster() {
        return isFraudster;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setFraudster(boolean fraudster) {
        isFraudster = fraudster;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FraudCheckHistory{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", isFraudster=" + isFraudster +
                ", createdAt=" + createdAt +
                '}';
    }


    public FraudCheckHistory(Integer id, Integer customerId, boolean isFraudster, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.isFraudster = isFraudster;
        this.createdAt = createdAt;
    }

    public FraudCheckHistory() {

    }


    public static FraudCheckHistoryBuilder builder() {
        return new FraudCheckHistoryBuilder();
    }

    public static class FraudCheckHistoryBuilder {
        private Integer id;
        private Integer customerId;
        private boolean isFraudster;
        private LocalDateTime createdAt;

        FraudCheckHistoryBuilder() {
        }

        public FraudCheckHistoryBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public FraudCheckHistoryBuilder customerId(Integer customerId) {
            this.customerId = customerId;
            return this;
        }

        public FraudCheckHistoryBuilder isFraudster(boolean isFraudster) {
            this.isFraudster = isFraudster;
            return this;
        }

        public FraudCheckHistoryBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FraudCheckHistory build() {
            return new FraudCheckHistory(id, customerId, isFraudster, createdAt);
        }
    }
}