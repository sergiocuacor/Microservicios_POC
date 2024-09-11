package com.sergiocuacor.microservices.verifier;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Entidad JPA
public class VerifierCheckHistory { // Historial de verificaciones de fraude
    /*
    @Id para marcar id como PK,
    @SequenceGenerator y @GeneratedValue para configurar
    la generación automática de IDs usando una secuencia de base de datos. */
    @Id
    @SequenceGenerator(name = "verifier_id_sequence", sequenceName = "verifier_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verifier_id_sequence")
    private Integer id;
    private Integer customerId;
    private boolean isValid;
    private LocalDateTime createdAt;

    public VerifierCheckHistory(Integer id, Integer customerId, boolean isValid, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.isValid = isValid;
        this.createdAt = createdAt;
    }

    public VerifierCheckHistory() {

    }


    @Override
    public String toString() {
        return "VerifierCheckHistory{" + "id=" + id + ", customerId=" + customerId + ", isValid=" + isValid + ", createdAt=" + createdAt + '}';
    }


    public static VerifierCheckHistoryBuilder builder() {
        return new VerifierCheckHistoryBuilder();
    }

    public static class VerifierCheckHistoryBuilder {
        private Integer id;
        private Integer customerId;
        private boolean isValid;
        private LocalDateTime createdAt;

        VerifierCheckHistoryBuilder() {
        }

        public VerifierCheckHistoryBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public VerifierCheckHistoryBuilder customerId(Integer customerId) {
            this.customerId = customerId;
            return this;
        }

        public VerifierCheckHistoryBuilder isValid(boolean isValid) {
            this.isValid = isValid;
            return this;
        }

        public VerifierCheckHistoryBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VerifierCheckHistory build() {
            return new VerifierCheckHistory(id, customerId, isValid, createdAt);
        }
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isValid() {
        return isValid;
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

    public void setVerifier(boolean valid) {
        isValid = valid;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}