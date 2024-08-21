package com.william.booking.bill.springboot.booking_springboot.entities;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    private Long id;

    @NotBlank(message="{NotBlank}")
    @Size(max = 100, message="{Size}")
    @Column(nullable=false, length=100)
    private String name;

    @NotBlank(message="{NotBlank}")
    @Email(message="{Email}")
    private String email;

    @NotBlank(message="{NotBlank}")
    @Size(max = 10)
    private String phone;

    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    // List<Order> orderList = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // public List<Order> getOrderList() {
    //     return orderList;
    // }

    // public void setOrderList(List<Order> orderList) {
    //     this.orderList = orderList;
    // }

    
    
}
