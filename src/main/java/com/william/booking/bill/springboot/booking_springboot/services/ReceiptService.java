package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import com.william.booking.bill.springboot.booking_springboot.entities.Receipt;

public interface ReceiptService{

    Optional<Receipt> createReceipt(Receipt receipt);
}
