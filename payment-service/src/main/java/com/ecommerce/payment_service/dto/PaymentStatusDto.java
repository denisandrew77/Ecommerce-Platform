package com.ecommerce.payment_service.dto;

import com.ecommerce.payment_service.enums.Status;

public class PaymentStatusDto {
    private String orderName;
    private Status status;
    private boolean success;

    public PaymentStatusDto(String orderName, Status status,  boolean success) {
        this.orderName = orderName;
        this.status = status;
        this.success = success;
    }

    public String getOrderName() {
        return orderName;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return success;
    }
}
