package com.william.booking.bill.springboot.booking_springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.william.booking.bill.springboot.booking_springboot.entities.Receipt;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long>{
}
