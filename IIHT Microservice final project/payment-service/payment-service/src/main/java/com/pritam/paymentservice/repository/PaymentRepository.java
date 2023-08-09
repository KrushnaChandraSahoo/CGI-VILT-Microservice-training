package com.pritam.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.paymentservice.entity.TransactionDetail;

public interface PaymentRepository extends JpaRepository<TransactionDetail, Long> {
}
