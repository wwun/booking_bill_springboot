package com.william.booking.bill.springboot.booking_springboot.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.william.booking.bill.springboot.booking_springboot.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    boolean existsByEmail(String email);
    Optional<Client> findByEmail(String email);
}
