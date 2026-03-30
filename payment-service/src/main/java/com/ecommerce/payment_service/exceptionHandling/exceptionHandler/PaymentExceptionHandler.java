package com.ecommerce.payment_service.exceptionHandling.exceptionHandler;

import com.ecommerce.payment_service.exceptionHandling.exception.AlreadyPaidException;
import com.ecommerce.payment_service.exceptionHandling.exception.LowBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = LowBalanceException.class)
    public ResponseEntity<String> handleLowBalanceException(LowBalanceException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AlreadyPaidException.class)
    public ResponseEntity<String> handleAlreadyPaidException(AlreadyPaidException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
