package com.ecommerce.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.payment_service.dto.PaymentDto;
import com.ecommerce.payment_service.dto.PaymentStatusDto;
import com.ecommerce.payment_service.enums.Status;
import com.ecommerce.payment_service.exceptionHandling.exception.LowBalanceException;
import com.ecommerce.payment_service.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments/pay")
    public ResponseEntity<PaymentStatusDto> pay(@RequestBody PaymentDto paymentDto) {
        try {
            paymentService.processPayment(paymentDto);
            return new ResponseEntity<>(new PaymentStatusDto(paymentDto.getOrderName(), Status.SUCCESS, true), HttpStatus.OK);
        } catch (LowBalanceException ex) {
            return new ResponseEntity<>(new PaymentStatusDto(paymentDto.getOrderName(), Status.PAYMENT_FAILED, false), HttpStatus.PAYMENT_REQUIRED);
        }
    }
}
