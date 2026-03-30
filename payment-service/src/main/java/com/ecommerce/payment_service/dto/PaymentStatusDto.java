package com.ecommerce.payment_service.dto;

import com.ecommerce.payment_service.enums.Status;

public class PaymentStatusDto {
    private String orderName;
    private Status status;

    public PaymentStatusDto(String orderName, Status status) {
        this.orderName = orderName;
        this.status = status;
    }

    public String getOrderName() {
        return orderName;
    }

    public Status getStatus() {
        return status;
    }
}
