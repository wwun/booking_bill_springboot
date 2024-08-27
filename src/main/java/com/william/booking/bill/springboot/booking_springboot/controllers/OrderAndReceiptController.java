package com.william.booking.bill.springboot.booking_springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.william.booking.bill.springboot.booking_springboot.dtos.OrderAndReceiptDTO;
import com.william.booking.bill.springboot.booking_springboot.services.OrderAndReceiptService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/orderDetail")
public class OrderAndReceiptController {
    
    private final OrderAndReceiptService orderAndReceiptService;

    public OrderAndReceiptController(OrderAndReceiptService orderAndReceiptService){
        this.orderAndReceiptService = orderAndReceiptService;
    }

    @PostMapping
    public ResponseEntity<?> createOrderAndPayment(@Valid @RequestBody OrderAndReceiptDTO orderAndReceiptDTO){
        
        int orderAndReceiptSaved = orderAndReceiptService.createOrderAndReceipt(orderAndReceiptDTO);

        System.out.println("entities saved: "+orderAndReceiptSaved);

        if(orderAndReceiptSaved >= 2)
            return ResponseEntity.status(HttpStatus.OK).build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
