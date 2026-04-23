package com.p2p.domain;

import java.math.BigDecimal;

public class Loan {

    // Enum untuk status loan
    public enum Status {
        PENDING, APPROVED, REJECTED, FUNDED, ACTIVE, COMPLETED
    }

    private Status status;
    private BigDecimal amount;
    private BigDecimal outstanding;

    // Saat loan dibuat, status awal adalah PENDING
    public Loan() {
        this.status = Status.PENDING;
    }

    public Loan(BigDecimal amount) {
        this.status = Status.PENDING;
        this.amount = amount;
        this.outstanding = amount;
    }

    //---GETTER---
    public Status getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getOutstanding() {
        return outstanding;
    }

    //Domain Behavior
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }

    public void fund() {
        this.status = Status.FUNDED;
    }

    public void activate() {
        this.status = Status.ACTIVE;
    }

    public void repay(BigDecimal paymentAmount) {
        if (paymentAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be getter than zero");
        }

        this.outstanding = this.outstanding.subtract(paymentAmount);

        if (this.outstanding.compareTo(BigDecimal.ZERO) == 0) {
            this.status = Status.COMPLETED;
        }
    }
}
