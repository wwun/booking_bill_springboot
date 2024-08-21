package com.william.booking.bill.springboot.booking_springboot.dtos;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class OrderAndReceiptDTO {

    private String clientEmail;

    private String orderHour;

    @JsonProperty("table")
    private Integer orderTable;

    @JsonProperty("orders")
    private List<OrderDetailAndQuantityDTO> ordersAndQuantity;

    private BigDecimal tip;

    private Long paymentAmount;

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getOrderHour() {
        return orderHour;
    }

    public void setOrderHour(String orderHour) {
        this.orderHour = orderHour;
    }

    public Integer getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(Integer orderTable) {
        this.orderTable = orderTable;
    }

    public List<OrderDetailAndQuantityDTO> getOrdersAndQuantity() {
        return ordersAndQuantity;
    }

    public void setOrdersAndQuantity(List<OrderDetailAndQuantityDTO> ordersAndQuantity) {
        this.ordersAndQuantity = ordersAndQuantity;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

}

// let order = {
//     clientName: '',
//     table: '',
//     time: '',
//     orders: []
// }