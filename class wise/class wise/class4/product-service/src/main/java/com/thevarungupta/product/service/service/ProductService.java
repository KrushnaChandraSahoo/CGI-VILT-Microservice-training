package com.thevarungupta.product.service.service;

import com.thevarungupta.product.service.model.ProductRequest;
import com.thevarungupta.product.service.model.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    ProductResponse getProductById(Long productId);

    void reduceQuantity(Long productId, Long quantity);
}
