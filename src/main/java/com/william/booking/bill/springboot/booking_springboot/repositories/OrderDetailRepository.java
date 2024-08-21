package com.william.booking.bill.springboot.booking_springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.william.booking.bill.springboot.booking_springboot.entities.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{

}
