package com.william.booking.bill.springboot.booking_springboot.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
