package com.william.booking.bill.springboot.booking_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.william.booking.bill.springboot.booking_springboot.dtos.OrderAndReceiptDTO;
import com.william.booking.bill.springboot.booking_springboot.services.OrderAndReceiptService;
import com.william.booking.bill.springboot.booking_springboot.services.SharedService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/orderDetail")
public class OrderAndReceiptController {
    
    private OrderAndReceiptService orderAndReceiptService;
    private final SharedService sharedService;

    public OrderAndReceiptController(OrderAndReceiptService orderAndReceiptService, SharedService sharedService){
        this.orderAndReceiptService = orderAndReceiptService;
        this.sharedService = sharedService;
    }

    @PostMapping
    public ResponseEntity<?> createOrderAndPayment(@Valid @RequestBody OrderAndReceiptDTO orderAndReceiptDTO){
        try{
            System.out.println("ordeeeeeeeeeeeeeeeeeeeer id"+sharedService.getOrderId());
            System.out.println(new ObjectMapper().writeValueAsString(orderAndReceiptDTO));
        }catch(Exception ex){
            System.out.println("error: "+ex.getMessage());
        }
        int orderAndReceiptSaved = orderAndReceiptService.createOrderAndReceipt(orderAndReceiptDTO);

        System.out.println("entities saved: "+orderAndReceiptSaved);

        if(orderAndReceiptSaved >= 2)
            return ResponseEntity.status(HttpStatus.OK).build();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
