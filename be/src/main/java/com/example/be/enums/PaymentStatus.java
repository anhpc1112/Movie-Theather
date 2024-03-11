package com.example.be.enums;

public enum PaymentStatus {
    PAID(0),
    UNPAID(1),
    PROCESSING(2),
    ERROR(3);

    public final int value;

    PaymentStatus(int value) {
        this.value = value;
    }

    public int getValue () {
        return value;
    }

    PaymentStatus fromValue(int value) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.value == value) return paymentStatus;
        }
        throw new IllegalArgumentException("Invalid Status value: " + value);
    }
}
