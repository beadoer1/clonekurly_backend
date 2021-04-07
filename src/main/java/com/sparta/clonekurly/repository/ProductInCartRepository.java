package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInCartRepository extends JpaRepository<ProductInCart, Long> {
}
