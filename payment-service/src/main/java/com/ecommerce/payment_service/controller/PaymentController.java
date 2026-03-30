package com.ecommerce.payment_service.controller;

import com.ecommerce.payment_service.dto.PaymentDto;
import com.ecommerce.payment_service.dto.PaymentStatusDto;
import com.ecommerce.payment_service.entity.Payment;
import com.ecommerce.payment_service.enums.Status;
import com.ecommerce.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments/pay")
    public ResponseEntity<PaymentStatusDto> pay(@RequestBody PaymentDto paymentDto) {
        boolean paymentSuccesfull = paymentService.processPayment(paymentDto);
        if (paymentSuccesfull) {
            PaymentStatusDto statusDto = new PaymentStatusDto(paymentDto.getOrderName(), Status.SUCCESS);
            return new ResponseEntity<>(statusDto, HttpStatus.OK);
        }
        else {
            PaymentStatusDto statusDto = new PaymentStatusDto(paymentDto.getOrderName(), Status.PAYMENT_FAILED);
            return new ResponseEntity<>(statusDto,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
