package com.example.be.service;

import java.util.List;

public interface ReservationService {
    void checkAndCancelReservations();

    void reverse(List<String> seats);
}
