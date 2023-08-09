package com.pritam.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
