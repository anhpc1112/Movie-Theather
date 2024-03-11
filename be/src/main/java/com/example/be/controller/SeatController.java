package com.example.be.controller;

import com.example.be.dto.request.SeatRequest;
import com.example.be.enums.SeatStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/create")
    public ResponseEntity<Seat> createSeat(@RequestBody SeatRequest req) {
        Seat seat = seatRepository.save(
                Seat.builder()
                        .seatNumber(req.getSeatNumber())
                        .rowNumber(req.getRowNumber())
                        .seatStatus(SeatStatus.AVAILABLE)
                        .build());
        return ResponseEntity.ok(seat);
    }
}
