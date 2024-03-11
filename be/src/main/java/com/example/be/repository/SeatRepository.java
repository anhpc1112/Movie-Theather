package com.example.be.repository;

import com.example.be.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findByRowNumberAndSeatNumber(String rowNumber, String seatNumber);
}
