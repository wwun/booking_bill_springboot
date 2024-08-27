package com.william.booking.bill.springboot.booking_springboot.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
