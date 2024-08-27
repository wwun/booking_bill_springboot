package com.william.booking.bill.springboot.booking_springboot.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionException;
import org.springframework.dao.DataAccessResourceFailureException;

import com.william.booking.bill.springboot.booking_springboot.dtos.HandlerExceptionDto;
import com.william.booking.bill.springboot.booking_springboot.exceptions.BadRequestException;
import com.william.booking.bill.springboot.booking_springboot.exceptions.NotFoundException;
import com.william.booking.bill.springboot.booking_springboot.exceptions.OrderProcessingException;
import com.william.booking.bill.springboot.booking_springboot.exceptions.UserNotFoundException;

import jakarta.persistence.QueryTimeoutException;

import java.sql.SQLException;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({DataIntegrityViolationException.class, TransactionException.class, DataAccessResourceFailureException.class, QueryTimeoutException.class})
    public ResponseEntity<?> handleDatabaseException(SQLException ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setMessage(ex.getMessage());
        handlerExceptionDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerExceptionDto.setTypeOfError("Problem with Database");
        handlerExceptionDto.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerExceptionDto);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> handleUserNotFoundException(Exception ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setMessage(ex.getMessage());
        handlerExceptionDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerExceptionDto.setTypeOfError("Problem with User");
        handlerExceptionDto.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerExceptionDto);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setMessage(ex.getMessage());
        handlerExceptionDto.setStatus(HttpStatus.BAD_REQUEST.value());
        handlerExceptionDto.setTypeOfError("Bad Request");
        handlerExceptionDto.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(handlerExceptionDto);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setMessage(ex.getMessage());
        handlerExceptionDto.setStatus(HttpStatus.NOT_FOUND.value());
        handlerExceptionDto.setTypeOfError("Resource Not Found");
        handlerExceptionDto.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(handlerExceptionDto);
    }

    @ExceptionHandler({OrderProcessingException.class})
    public ResponseEntity<?> handleOrderProcessingException(OrderProcessingException ex){
        HandlerExceptionDto handlerExceptionDto = new HandlerExceptionDto();
        handlerExceptionDto.setMessage(ex.getMessage());
        handlerExceptionDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerExceptionDto.setTypeOfError("Order Processing Error");
        handlerExceptionDto.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerExceptionDto);
    }

}
