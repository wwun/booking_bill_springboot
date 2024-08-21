package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import com.william.booking.bill.springboot.booking_springboot.entities.OrderDetail;

public interface OrderDetailService {
    Optional<OrderDetail> createOrderDetail(OrderDetail orderDetail);
}
