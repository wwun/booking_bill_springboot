package com.william.booking.bill.springboot.booking_springboot.controllers;

import java.util.Optional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.booking.bill.springboot.booking_springboot.dtos.BookingDTO;
import com.william.booking.bill.springboot.booking_springboot.entities.Client;
import com.william.booking.bill.springboot.booking_springboot.entities.Order;
import com.william.booking.bill.springboot.booking_springboot.services.ClientService;
import com.william.booking.bill.springboot.booking_springboot.services.DishService;
import com.william.booking.bill.springboot.booking_springboot.services.OrderService;
import com.william.booking.bill.springboot.booking_springboot.services.SharedService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class BookingController {

    // @Autowired
    // ClientService clientService;

    // @Autowired
    // OrderService orderService;

    // @Autowired
    // DishService dishService;

    // @Autowired
    // BookingDTO bookingDTO;

    // inyección por constructor, prácticas actuales
    private final ClientService clientService;
    private final OrderService orderService;
    private final DishService dishService;
    private final SharedService sharedService;

    // Inyección por constructor
    public BookingController(ClientService clientService, OrderService orderService, DishService dishService, SharedService sharedService) {
        this.clientService = clientService;
        this.orderService = orderService;
        this.dishService = dishService;
        this.sharedService = sharedService;
    }

    @PostMapping("/clientBooking")
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingDTO bookingDTO, BindingResult result){
        if(result.hasFieldErrors()){
            System.out.println("error: "+result.getAllErrors());
        }

        System.out.println("client book");
        String clientName = bookingDTO.getClientName();
        String clientEmail = bookingDTO.getClientEmail();
        String clientPhone = bookingDTO.getClientPhone();

        Integer orderReservedTable = bookingDTO.getTableReserved();
        Long orderId = System.currentTimeMillis();
        
        LocalTime orderTime = bookingDTO.getTimeReserved();
        LocalDateTime orderLocalDateTime = orderTime.atDate(LocalDate.now());   //join date and time

        Client client = new Client();
        
        if(clientService.existsByEmail(clientEmail)){
            Optional<Client> clientExistentOptional = clientService.findByEmail(clientEmail);
            if(clientExistentOptional.isPresent()){
                client = clientService.findByEmail(clientEmail).get();
                sharedService.setClientId(client.getId());
            }            
        }else{
            Long clientId = System.currentTimeMillis();
            client.setId(clientId);
            sharedService.setClientId(clientId);
        }
        client.setName(clientName);
        client.setEmail(clientEmail);
        client.setPhone(clientPhone);

        Order order = new Order();
        order.setId(orderId);
        order.setReservedTable(orderReservedTable);
        order.setClient(client);
        order.setDateTime(orderLocalDateTime);

        sharedService.setOrderId(orderId);
        // client.getOrderList().add(order);

        try{
            clientService.createClient(client);
            orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.OK).body(bookingDTO);
        }catch(Exception ex){
            System.out.println("error: "+ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/dishes")
    public ResponseEntity<?> getAllDishes(){
        return ResponseEntity.status(HttpStatus.OK).body(dishService.listAllDishes());
    }
}
