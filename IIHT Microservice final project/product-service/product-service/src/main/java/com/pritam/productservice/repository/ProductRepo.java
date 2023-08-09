package com.pritam.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.productservice.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
