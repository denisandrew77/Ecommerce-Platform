package com.ecommerce.payment_service.entity;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String orderName;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private Double amount;

    public Payment() {}

    public Payment(String orderName, String customerName, Double amount) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }
}
