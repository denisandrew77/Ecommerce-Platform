package com.ecommerce.order_service.dto.clients;

public class PaymentStatusDto {
    private boolean success;

    public PaymentStatusDto() {}

    public PaymentStatusDto(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
