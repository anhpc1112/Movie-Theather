package com.example.be.scheduled;

import com.example.be.enums.SeatStatus;
import com.example.be.model.Seat;
import com.example.be.repository.SeatRepository;
import com.example.be.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
public class CancelReservationAutomatic {

    private boolean shouldRun = true;

    @Autowired
    private SeatRepository seatRepository;

    @Scheduled(fixedDelay = 30000, initialDelay = 30000) // Cron expression for running every minute
    public void cancelReservation() {
        if (shouldRun) {
            Seat seat = seatRepository.findById(1L).orElseThrow(NullPointerException::new);
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seatRepository.save(seat);
            log.info(String.format("Canceled seat with id: %s after 10 minutes", 1));
            shouldRun = false;
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 10*60*1000);
    }

    public void activateTask() {
        shouldRun = true;
    }
}
