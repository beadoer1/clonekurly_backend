package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnCart;
import com.sparta.clonekurly.model.Cart;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.model.ProductInCart;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.CartRepository;
import com.sparta.clonekurly.repository.ProductRepository;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @GetMapping("/api/cart")
    public ReturnCart getCartByUser(){ // 사용자 식별 정보 필요(token),
        User user = userRepository.findByUsername("asdf").orElseThrow(
                () -> new IllegalArgumentException("야호")
        );  // 같이 온 Token에서 꺼냈다고 가정
        return cartService.getCartByUser(user);
    }

    @PostMapping("/api/cart/product")
    public void plusProductToCart(@RequestBody Map<String, Long> requestData){ // { "id" : 3, "nums" : 3}
        User user = userRepository.findByUsername("asdf").orElseThrow(
                () -> new IllegalArgumentException("야호")
        );  // 같이 온 Token에서 꺼냈다고 가정
        Long productId = requestData.get("id");
        Long nums = requestData.get("nums");
        cartService.plusProductToCart(user, productId, nums);
    }
}
