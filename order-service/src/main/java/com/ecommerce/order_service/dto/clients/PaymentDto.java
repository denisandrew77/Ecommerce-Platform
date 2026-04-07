package com.ecommerce.order_service.dto.clients;

public class PaymentDto {
    private String orderName;
    private String customerName;
    private Double amount;
    private Double userAmount;

    public PaymentDto(String orderName, String customerName, Double amount, Double userAmount) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.amount = amount;
        this.userAmount = userAmount;
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

    public Double getUserAmount() {
        return userAmount;
    }
}
