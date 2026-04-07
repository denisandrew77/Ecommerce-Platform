package com.ecommerce.order_service.dto.responseEntity;

public class OrderState {
    private boolean success;
    private String message;
    public OrderState(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
