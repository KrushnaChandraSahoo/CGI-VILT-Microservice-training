package com.pritam.productservice.service;

import com.pritam.productservice.model.ProductRequest;
import com.pritam.productservice.model.ProductResponse;

public interface ProductService {
	ProductResponse addProduct(ProductRequest product);
	ProductResponse getProductById(Long id);
	void reduceQuantity(Long productId, Long quantity);
}
