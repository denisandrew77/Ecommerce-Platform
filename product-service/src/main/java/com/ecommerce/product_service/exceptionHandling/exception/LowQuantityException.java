package com.ecommerce.product_service.exceptionHandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class LowQuantityException extends RuntimeException {
    public LowQuantityException(String message) {
        super(message);
    }
}
