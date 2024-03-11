package com.example.be.enums;

public enum SeatStatus {
    AVAILABLE(0),
    RESERVED(1),
    BLOCKED(2);

    private final int value;

    SeatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SeatStatus fromValue(int value) {
        for (SeatStatus seatStatus : SeatStatus.values()) {
            if (seatStatus.value == value) return seatStatus;
        }
        throw new IllegalArgumentException("Invalid Status value: " + value);
    }

}
