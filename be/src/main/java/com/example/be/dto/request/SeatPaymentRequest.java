package com.example.be.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class SeatPaymentRequest {

    private List<String> seatIds;
}
