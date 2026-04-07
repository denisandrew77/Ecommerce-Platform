package com.ecommerce.payment_service.service;

import com.ecommerce.payment_service.dto.PaymentDto;
import com.ecommerce.payment_service.entity.Payment;
import com.ecommerce.payment_service.exceptionHandling.exception.AlreadyPaidException;
import com.ecommerce.payment_service.exceptionHandling.exception.LowBalanceException;
import com.ecommerce.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processPayment(PaymentDto paymentDto) {
        if(paymentRepository.findByOrderName(paymentDto.getOrderName()).isPresent()){
            throw new AlreadyPaidException("Order already paid");
        } else {
            if(paymentDto.getUserAmount() >= paymentDto.getAmount()){
                paymentRepository.save(new Payment(paymentDto.getOrderName(), paymentDto.getCustomerName(), paymentDto.getAmount()));
            } else {
                throw new LowBalanceException("Insufficient balance");
            }
        }
    }
}
