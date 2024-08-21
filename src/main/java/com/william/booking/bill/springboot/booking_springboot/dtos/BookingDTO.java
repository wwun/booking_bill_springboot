package com.william.booking.bill.springboot.booking_springboot.dtos;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class BookingDTO {
    
    private Long id;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private Integer tableReserved;
    private LocalTime timeReserved;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
    public String getClientPhone() {
        return clientPhone;
    }
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
    public Integer getTableReserved() {
        return tableReserved;
    }
    public void setTableReserved(Integer tableReserved) {
        this.tableReserved = tableReserved;
    }
    public LocalTime getTimeReserved() {
        return timeReserved;
    }
    public void setTimeReserved(LocalTime timeReserved) {
        this.timeReserved = timeReserved;
    }

    
}
