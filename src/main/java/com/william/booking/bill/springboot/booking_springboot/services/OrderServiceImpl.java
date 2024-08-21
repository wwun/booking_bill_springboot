package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.william.booking.bill.springboot.booking_springboot.entities.Order;
import com.william.booking.bill.springboot.booking_springboot.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public Optional<Order> createOrder(Order order){
        if(order==null)
            return Optional.empty();

        //if(!orderRepository.existsById(order.getId())){
            return Optional.of(orderRepository.save(order));
        //}

        //return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }
}
