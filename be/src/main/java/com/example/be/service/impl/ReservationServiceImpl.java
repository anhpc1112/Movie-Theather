package com.example.be.service.impl;

import com.example.be.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {


    /**
     * Cron job
     */
    @Override
    public void checkAndCancelReservations() {
        log.info("Cron job executed!");
    }

    /**
     *
     * reverse seats
     * @param seats seats
     */
    @Override
    public void reverse(List<String> seats) {
        // TODO
    }
}
