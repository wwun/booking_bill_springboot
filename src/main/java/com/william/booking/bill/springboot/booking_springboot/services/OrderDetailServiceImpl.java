package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.booking.bill.springboot.booking_springboot.entities.OrderDetail;
import com.william.booking.bill.springboot.booking_springboot.repositories.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public Optional<OrderDetail> createOrderDetail(OrderDetail orderDetail){
        return Optional.of(orderDetailRepository.save(orderDetail));
    }

}
