package com.thevarungupta.order.service.service;

import com.thevarungupta.order.service.model.OrderRequest;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
}
