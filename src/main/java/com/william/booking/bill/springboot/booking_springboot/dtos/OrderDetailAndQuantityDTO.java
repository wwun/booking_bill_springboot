package com.william.booking.bill.springboot.booking_springboot.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailAndQuantityDTO {
    
    @JsonProperty("id")
    private Long dishId;

    @JsonProperty("quantity")
    private Integer quantityOrdered;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }
}
