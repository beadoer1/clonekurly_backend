package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
