package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import com.william.booking.bill.springboot.booking_springboot.entities.Client;

public interface ClientService {
    Optional<Client> createClient(Client client);
    Optional<Client> updateClient(Client client);
    boolean existsByEmail(String email);    //temporal while validation is being done in controller
    Optional<Client> findByEmail(String email);    //temporal while validation is being done in controller
    // List<Order> getOrdersByEmail(String email);    //temporal while validation is being done in controller
}
