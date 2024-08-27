package com.william.booking.bill.springboot.booking_springboot.dtos;

import java.time.LocalDateTime;

public class HandlerExceptionDto {
    
    String typeOfError;
    String message;
    Integer status;
    LocalDateTime date;

    public String getTypeOfError() {
        return typeOfError;
    }
    public void setTypeOfError(String typeOfError) {
        this.typeOfError = typeOfError;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
}
