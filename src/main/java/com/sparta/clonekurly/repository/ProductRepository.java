package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNo(Long no);
//    List<Product> findByDiscounted_priceGreaterThan(Long num, Pageable pageable);
}
