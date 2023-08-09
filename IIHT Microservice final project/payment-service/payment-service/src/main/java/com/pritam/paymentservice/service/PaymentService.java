package com.pritam.paymentservice.service;

import com.pritam.paymentservice.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
