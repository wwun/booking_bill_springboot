package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.william.booking.bill.springboot.booking_springboot.entities.Dish;
import com.william.booking.bill.springboot.booking_springboot.repositories.DishRepository;

@Service
public class DishServiceImpl implements DishService{

    @Autowired
    DishRepository dishRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Dish> listAllDishes(){
        return (List<Dish>)dishRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dish> getDishById(Long id){
        return dishRepository.findById(id);
    }

}
