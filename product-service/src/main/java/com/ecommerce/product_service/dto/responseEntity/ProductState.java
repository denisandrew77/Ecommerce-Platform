package com.ecommerce.product_service.dto.responseEntity;

public class ProductState {
    private boolean available;
    private String message;
    public ProductState(boolean available, String message) {
        this.available = available;
        this.message = message;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getMessage() {
        return message;
    }
}
