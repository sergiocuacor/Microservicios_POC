package com.sergiocuacor.microservices.customer;

import java.util.Objects;

public class FraudCheckResponse {

    private Boolean isFraudster;

    public FraudCheckResponse(){
    }

    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public Boolean getIsFraudster() {
        return isFraudster;
    }

    public void setIsFraudster(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    @Override
    public String toString() {
        return "FraudCheckResponse{" +
                "isFraudster=" + isFraudster +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FraudCheckResponse that = (FraudCheckResponse) o;
        return Objects.equals(isFraudster, that.isFraudster);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isFraudster);
    }
}
