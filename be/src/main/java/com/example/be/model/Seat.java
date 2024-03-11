package com.example.be.model;

import com.example.be.enums.PaymentStatus;
import com.example.be.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "seats")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String rowNumber;

    private String seatNumber;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
