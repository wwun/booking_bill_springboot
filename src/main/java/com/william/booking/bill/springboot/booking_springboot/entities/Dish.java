package com.william.booking.bill.springboot.booking_springboot.entities;

import java.math.BigDecimal;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Dish")
public class Dish {

    @Id
    private Long id;

    @NotNull(message = "{NotNull}")
    @NotBlank(message = "{NotBlank}")
    @Size(max=100, message = "{Size}")
    private String name;

    @NotNull(message = "{NotNull}")
    @Digits(integer = 5, fraction = 2, message="{Digits.price}")
    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @Column(nullable = false)
    private boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    
}
