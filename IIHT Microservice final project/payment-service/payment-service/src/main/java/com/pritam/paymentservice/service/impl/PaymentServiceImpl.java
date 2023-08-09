package com.pritam.paymentservice.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.paymentservice.entity.TransactionDetail;
import com.pritam.paymentservice.model.PaymentRequest;
import com.pritam.paymentservice.repository.PaymentRepository;
import com.pritam.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("record payment details: {}", paymentRequest);
        TransactionDetail transactionDetail = TransactionDetail.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(transactionDetail);
        log.info("transaction completed with id: {}", transactionDetail.getId());
        return transactionDetail.getId();
    }
}
