package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnCart;
import com.sparta.clonekurly.controllerReturn.ReturnCheckId;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.CartRepository;
import com.sparta.clonekurly.repository.ProductInCartRepository;
import com.sparta.clonekurly.repository.ProductRepository;
import com.sparta.clonekurly.repository.UserRepository;
import com.sparta.clonekurly.security.JwtTokenProvider;
import com.sparta.clonekurly.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductInCartRepository productInCartRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/api/carts")
    public ReturnCart getCartByUser(@AuthenticationPrincipal User user) { // 사용자 식별 정보 필요(token),
        return cartService.getCartByUser(user);
    }

    @PostMapping("/api/carts/products")
    public void plusProductInCart(@RequestBody Map<String, Long> requestData, @AuthenticationPrincipal User user) { // { "id" : 3, "nums" : 3}
        Long productId = requestData.get("id");
        Long nums = requestData.get("nums");
        cartService.plusProductToCart(user, productId, nums);
    }

    @DeleteMapping("/api/carts/products/{id}")
    public ReturnCheckId deleteProductInCart(@PathVariable Long id) {
        ReturnCheckId returnCheckId = new ReturnCheckId();
        try {
            productInCartRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("해당 상품이 장바구니에 존재하지 않습니다.")
            );
        } catch (IllegalArgumentException e) {
            returnCheckId.setOk(false);
            returnCheckId.setMsg(e.getMessage());
            return returnCheckId;
        }
        productInCartRepository.deleteById(id);
        returnCheckId.setOk(true);
        returnCheckId.setMsg("상품을 삭제 완료 하였습니다.");
        return returnCheckId;
    }

    @PutMapping("/api/carts/products")
    public ReturnCheckId updateProductInCart(@RequestBody List<Map<String, Long>> requestData) {
        ReturnCheckId returnCheckId = new ReturnCheckId();
        try {
            cartService.updateProductInCart(requestData);
            returnCheckId.setOk(true);
            returnCheckId.setMsg("업데이트 성공!");
        } catch (IllegalArgumentException e) {
            returnCheckId.setOk(false);
            returnCheckId.setMsg(e.getMessage());
        }
        return returnCheckId;
    }
}
