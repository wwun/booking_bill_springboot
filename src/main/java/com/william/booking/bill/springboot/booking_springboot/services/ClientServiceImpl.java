package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.booking.bill.springboot.booking_springboot.entities.Client;
import com.william.booking.bill.springboot.booking_springboot.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public Optional<Client> createClient(Client client){
        if(client==null)
            return Optional.empty();

        if(!clientRepository.existsById(client.getId()) && !clientRepository.existsByEmail(client.getEmail())){
            return Optional.of(clientRepository.save(client));
        }else{
            return updateClient(client);
        }
    }

    @Override
    @Transactional
    public Optional<Client> updateClient(Client client){
        Optional<Client> clientOptional = clientRepository.findByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            client.setId(clientOptional.get().getId());
            System.out.println(client.getId());
            return Optional.of(clientRepository.save(client));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email){
        return clientRepository.existsByEmail(email);
    }

    @Override
    public Optional<Client> findByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    // @Override
    // public List<Order> getOrdersByEmail(String email){
    //     return clientRepository.findByEmail(email).get().getOrderList();
    // }
}
