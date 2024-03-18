package com.example.be.scheduled;

import com.example.be.enums.SeatStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelReservationAutomatic {

    private final SeatRepository seatRepository;

    @Scheduled(fixedDelay = 30000, initialDelay = 30000) // Cron expression for running every minute
    public void cancelReservation() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Seat seat = seatRepository.findById(1L).orElseThrow(NullPointerException::new);
                seat.setSeatStatus(SeatStatus.AVAILABLE);
                seatRepository.save(seat);
                log.info(String.format("Canceled seat with id: %s after 10 minutes", 1));
            }
        }, (long) 10 * 60 * 1000);
    }
}
