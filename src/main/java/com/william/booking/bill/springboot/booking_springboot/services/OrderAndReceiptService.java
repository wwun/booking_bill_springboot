package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import com.william.booking.bill.springboot.booking_springboot.dtos.OrderAndReceiptDTO;

public interface OrderAndReceiptService {
    int createOrderAndReceipt(OrderAndReceiptDTO orderAndReceiptDTO);
}
