package com.thevarungupta.payment.service.service;

import com.thevarungupta.payment.service.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
