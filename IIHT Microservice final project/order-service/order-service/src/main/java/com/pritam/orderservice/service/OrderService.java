package com.pritam.orderservice.service;

import com.pritam.orderservice.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
