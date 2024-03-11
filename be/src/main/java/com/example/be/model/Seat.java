package com.example.be.model;

import com.example.be.enums.PaymentStatus;
import com.example.be.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "seats")
public class Seat extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatId")
    private Long seatId;

    @Column(name = "seat_row")
    private String seatRow;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "seat_status")
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @Column(name = "payment_status")
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
