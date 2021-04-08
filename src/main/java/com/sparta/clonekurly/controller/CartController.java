package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnCart;
import com.sparta.clonekurly.model.Cart;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.model.ProductInCart;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.CartRepository;
import com.sparta.clonekurly.repository.ProductRepository;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.security.JwtTokenProvider;
import com.sparta.clonekurly.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/api/carts")
    public ReturnCart getCartByUser(@AuthenticationPrincipal User user){ // 사용자 식별 정보 필요(token),
        return cartService.getCartByUser(user);
    }

    @PostMapping("/api/carts/products")
    public void plusProductToCart(@RequestBody Map<String, Long> requestData, @AuthenticationPrincipal User user){ // { "id" : 3, "nums" : 3}
        Long productId = requestData.get("id");
        Long nums = requestData.get("nums");
        cartService.plusProductToCart(user, productId, nums);
    }





}
