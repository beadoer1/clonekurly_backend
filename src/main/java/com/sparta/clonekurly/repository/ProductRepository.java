package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
