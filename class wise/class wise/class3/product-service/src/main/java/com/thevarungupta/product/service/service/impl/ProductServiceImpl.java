package com.thevarungupta.product.service.service.impl;

import com.thevarungupta.product.service.entity.Product;
import com.thevarungupta.product.service.model.ProductRequest;
import com.thevarungupta.product.service.model.ProductResponse;
import com.thevarungupta.product.service.repository.ProductRepository;
import com.thevarungupta.product.service.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
       log.info("adding new product...");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        ProductResponse response = new ProductResponse();
        copyProperties(product, response);
        return response;
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        log.info("fetching product by id: "+ productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product does not exist by id: "+ productId));
        ProductResponse response = new ProductResponse();
        copyProperties(product, response);
        return response;
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {
        log.info("reduce quantity {} for id: {}", productId, quantity);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product does not exist by id: "+ productId));

        if(product.getQuantity() < quantity){
            throw new RuntimeException("product does not have sufficient quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("product quantity updated successfully");
    }
}
