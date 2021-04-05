package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
