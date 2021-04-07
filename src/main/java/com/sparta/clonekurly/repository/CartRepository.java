package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Cart;
import com.sparta.clonekurly.model.ProductInCart;
import com.sparta.clonekurly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart ,Long> {
    Cart findByUser(User user);
}
