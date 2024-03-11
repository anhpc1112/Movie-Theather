package com.example.be.controller;

import com.example.be.dto.request.SeatPaymentRequest;
import com.example.be.enums.PaymentStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/payment")
    public void paySeat(@RequestBody SeatPaymentRequest req) {
        for (String seatId : req.getSeatIds()) {
            Seat seat = seatRepository.findById(Long.parseLong(seatId)).orElse(null);
            seat.setPaymentStatus(PaymentStatus.PAID);
            seatRepository.save(seat);
        }
    }
}
