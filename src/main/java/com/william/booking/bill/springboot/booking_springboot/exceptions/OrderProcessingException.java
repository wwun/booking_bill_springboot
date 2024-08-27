package com.william.booking.bill.springboot.booking_springboot.exceptions;

public class OrderProcessingException extends RuntimeException{
    public OrderProcessingException(String message){
        super(message);
    }
}
