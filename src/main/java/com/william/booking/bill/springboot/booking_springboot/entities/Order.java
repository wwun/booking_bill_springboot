package com.william.booking.bill.springboot.booking_springboot.entities;

import java.util.List;
import java.util.ArrayList;

import  java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    private Long id;

    @NotNull(message = "{NotNull}")
    @Column(name = "date")
    private LocalDateTime dateTime;

    @Min(value = 1)
    @Max(value = 12, message = "{Size}")
    @Column(name = "reserved_table")
    private Integer reservedTable;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    // @OneToOne(mappedBy = "", cascade = CascadeType.ALL, orphanRemoval = true)    //bidirectional relationship won't be considered
    // private Receipt receipt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getReservedTable() {
        return reservedTable;
    }

    public void setReservedTable(Integer reservedTable) {
        this.reservedTable = reservedTable;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    
}
