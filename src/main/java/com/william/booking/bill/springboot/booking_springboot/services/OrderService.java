package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import com.william.booking.bill.springboot.booking_springboot.entities.Order;

public interface OrderService{
    public Optional<Order> createOrder(Order order);
    public Optional<Order> getOrderById(Long id);
}
