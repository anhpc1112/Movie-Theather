package com.example.be.controller;

import com.example.be.dto.request.SeatPaymentRequest;
import com.example.be.enums.PaymentStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final SeatRepository seatRepository;

    @PostMapping("/payment")
    public void paySeat(@RequestBody SeatPaymentRequest req) {
        for (String seatId : req.getSeatIds()) {
            Seat seat = seatRepository.findById(Long.parseLong(seatId)).orElseThrow(NullPointerException::new);
            seat.setPaymentStatus(PaymentStatus.PAID);
            seatRepository.save(seat);
        }
    }
}
