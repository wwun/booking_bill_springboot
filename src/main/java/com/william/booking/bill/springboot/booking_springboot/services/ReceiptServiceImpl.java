package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.booking.bill.springboot.booking_springboot.entities.Receipt;
import com.william.booking.bill.springboot.booking_springboot.repositories.ReceiptRepository;

@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    ReceiptRepository receiptRepository;

    @Override
    @Transactional
    public Optional<Receipt> createReceipt(Receipt receipt){
        return Optional.of(receiptRepository.save(receipt));
    }
}
