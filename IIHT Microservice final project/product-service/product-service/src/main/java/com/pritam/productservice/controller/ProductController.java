package com.pritam.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pritam.productservice.model.ProductRequest;
import com.pritam.productservice.model.ProductResponse;
import com.pritam.productservice.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest req) {
		ProductResponse response = service.addProduct(req);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id")Long id) {
		ProductResponse res = service.getProductById(id);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	@PutMapping("/{id}/reduceQuantity")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId,
											   @RequestParam Long quantity){
		service.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
