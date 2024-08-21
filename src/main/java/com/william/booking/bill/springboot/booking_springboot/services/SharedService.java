package com.william.booking.bill.springboot.booking_springboot.services;

import org.springframework.stereotype.Service;

@Service
public class SharedService {

    private Long orderId;
    private Long clientId;
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
}
