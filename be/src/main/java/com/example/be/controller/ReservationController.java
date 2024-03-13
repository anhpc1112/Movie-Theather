package com.example.be.controller;

import com.example.be.dto.request.SeatRequest;
import com.example.be.enums.SeatStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import com.example.be.scheduled.CancelReservationAutomatic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final CancelReservationAutomatic cancelReservationAutomatic;

    private final SeatRepository seatRepository;

    @PostMapping("/reserve")
    public void reverse(@RequestBody List<SeatRequest> seats) {
        // TODO validate
        seats.forEach(seatReq -> {
            Seat seat =
                    seatRepository.findBySeatRowAndSeatNumber(seatReq.getRowNumber(), seatReq.getSeatNumber()).orElseThrow(NullPointerException::new);
            seat.setSeatStatus(SeatStatus.RESERVED);
            seatRepository.save(seat);
            cancelReservationAutomatic.cancelReservation();
        });
    }
}
