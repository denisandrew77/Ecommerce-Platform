package com.ecommerce.order_service.exceptionHandling.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.order_service.dto.responseEntity.OrderState;
import com.ecommerce.order_service.exceptionHandling.exception.OrderAlreadyExistsException;
import com.ecommerce.order_service.exceptionHandling.exception.PaymentFailedException;

import feign.FeignException;

@RestControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<OrderState> handleFeignException(FeignException exception) {
        OrderState state = new OrderState(false, exception.getMessage());
        int status = exception.status();
        HttpStatus httpStatus = (status > 0) ? HttpStatus.resolve(status) : null;
        if (httpStatus == null) httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(httpStatus).body(state);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<OrderState> handleException(Exception exception) {
        OrderState state = new OrderState(false, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(state);
    }

    @ExceptionHandler(OrderAlreadyExistsException.class)
    public ResponseEntity<OrderState> handleOrderAlreadyExistsException(OrderAlreadyExistsException exception) {
        OrderState state = new OrderState(false, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(state);
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<OrderState> handlePaymentFailedException(PaymentFailedException exception) {
        OrderState state = new OrderState(false, exception.getMessage());
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(state);
    }
}
