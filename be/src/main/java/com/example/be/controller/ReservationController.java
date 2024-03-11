package com.example.be.controller;

import com.example.be.dto.request.SeatRequest;
import com.example.be.enums.SeatStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/reserve")
    public void reverse(@RequestBody List<SeatRequest> seats) {
        // TODO validate
        seats.stream().forEach(seatReq -> {
            Seat seat =
                    seatRepository.findByRowNumberAndSeatNumber(seatReq.getRowNumber(), seatReq.getSeatNumber()).orElseThrow(NullPointerException::new);
            seat.setSeatStatus(SeatStatus.RESERVED);
            seatRepository.save(seat);
        });
    }
}
