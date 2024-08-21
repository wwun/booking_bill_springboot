package com.william.booking.bill.springboot.booking_springboot.services;

import java.util.Optional;
import java.util.List;

import com.william.booking.bill.springboot.booking_springboot.entities.Dish;

public interface DishService{
    List<Dish> listAllDishes();
    Optional<Dish> getDishById(Long id);
}
