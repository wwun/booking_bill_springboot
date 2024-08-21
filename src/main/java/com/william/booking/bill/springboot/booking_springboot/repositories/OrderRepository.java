package com.william.booking.bill.springboot.booking_springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.william.booking.bill.springboot.booking_springboot.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
