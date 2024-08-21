package com.william.booking.bill.springboot.booking_springboot.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
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
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    @Column(name="total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    @Column(precision = 10, scale = 2)
    private BigDecimal tip;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 10, fraction = 2, message = "{Digits.receipt.amount}")
    @Column(name="payment_amount", precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    
}
