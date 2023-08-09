package com.thevarungupta.order.service.service.impl;

import com.thevarungupta.order.service.entity.Order;
import com.thevarungupta.order.service.model.OrderRequest;
import com.thevarungupta.order.service.repository.OrderRepository;
import com.thevarungupta.order.service.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        // Order Entry -> save the data with status Order CREATED
        // Product Service -> block product (reduce the quantity)
        // Payment Service -> payments -> success -> complete else
        // cancelled

        log.info("place order request: {}", orderRequest);

        log.info("creating order with status CREATED");

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);
        log.info("order placed successfully with order Id: {}", order.getOrderId());
        return order.getOrderId();
    }
}
