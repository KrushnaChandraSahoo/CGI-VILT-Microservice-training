package com.thevarungupta.order.service.service.impl;

import com.thevarungupta.order.service.entity.Order;
import com.thevarungupta.order.service.external.client.PaymentService;
import com.thevarungupta.order.service.external.client.ProductService;
import com.thevarungupta.order.service.model.OrderRequest;
import com.thevarungupta.order.service.model.PaymentRequest;
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
    private ProductService productService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        // Order Entry -> save the data with status Order CREATED
        // Product Service -> block product (reduce the quantity)
        // Payment Service -> payments -> success -> complete else
        // cancelled

        log.info("place order request: {}", orderRequest);

        // check the product inventory and reduce the quantity
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

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

        log.info("calling payment service to complete the payment");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getOrderId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String orderStatus = null;
        try{
            paymentService.doPayment(paymentRequest);
            log.info("payment done successfully");
            orderStatus = "PLACED";
        }catch (Exception ex){
            log.error("error occurred in payment, changing order status: PAYMENT-FAILED");
            orderStatus = "PAYMENT-FAILED";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        log.info("order placed successfully with order id: {}", order.getOrderId());

        return order.getOrderId();
    }
}
