package com.thevarungupta.payment.service.repository;

import com.thevarungupta.payment.service.entity.TransactionDetail;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<TransactionDetail, Long> {
}
