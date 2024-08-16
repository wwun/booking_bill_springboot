package com.william.booking.bill.springboot.booking_springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Receipt")
public class Receipt {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="order_id_fk", nullable = false)
    private Order order;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    private Double totalAmount;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    private Double tip;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    private Double paymentAmount;
}
