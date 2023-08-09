package com.pritam.orderservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE/api/products")
public interface ProductService {

    @PutMapping("/{id}/reduceQuantity")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId,
                                               @RequestParam Long quantity);
}
