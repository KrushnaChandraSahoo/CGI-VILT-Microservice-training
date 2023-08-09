package com.pritam.productservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pritam.productservice.entity.Product;
import com.pritam.productservice.exception.ProductServiceException;
import com.pritam.productservice.model.ProductRequest;
import com.pritam.productservice.model.ProductResponse;
import com.pritam.productservice.repository.ProductRepo;
import com.pritam.productservice.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;

	@Override
	public ProductResponse addProduct(ProductRequest product) {
		log.info("adding new product");
		Product p = new Product();
		BeanUtils.copyProperties(product, p);
		ProductResponse productResponse = new ProductResponse();
		repo.save(p);
		BeanUtils.copyProperties(p, productResponse);
		return productResponse;
	}

	@Override
	public ProductResponse getProductById(Long id) {
		log.info("fetching product by id: " + id);
		Product product = repo.findById(id).orElseThrow(
				() -> new ProductServiceException("product does not exist by id: " + id, "PRODUCT_NOT_FOUND"));
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}

	@Override
	public void reduceQuantity(Long productId, Long quantity) {
		log.info("reduce quantity {} for id: {}", productId, quantity);
		Product product = repo.findById(productId).orElseThrow(
				() -> new ProductServiceException("product does not exist by id: " + productId, "PRODUCT_NOT_FOUND"));
		if (product.getQuantity() < quantity) {
			throw new ProductServiceException("product does not have sufficient quantity", "INSUFFICIENT_QUANTITY");
		}

		product.setQuantity(product.getQuantity() - quantity);
		repo.save(product);
		log.info("product quantity updated successfully");
	}
}
