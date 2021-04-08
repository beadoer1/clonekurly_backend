package com.sparta.clonekurly.service;

import com.sparta.clonekurly.controllerReturn.ReturnCart;
import com.sparta.clonekurly.model.Cart;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.model.ProductInCart;
import com.sparta.clonekurly.model.User;
import com.sparta.clonekurly.repository.CartRepository;
import com.sparta.clonekurly.repository.ProductInCartRepository;
import com.sparta.clonekurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductInCartRepository productInCartRepository;

    // cart 반환
    public ReturnCart getCartByUser(User user) {
        Cart cart = cartRepository.findByUser(user);
        ReturnCart returnCart = new ReturnCart();
        returnCart.setOk(true);
        returnCart.setResults(cart.getProductInCartList());
        return returnCart;
    }

    // cart에 상품 등록하기
    @Transactional
    public void plusProductToCart(User user, Long productId, Long nums){
        Cart cart = cartRepository.findByUser(user);
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 상품을 찾을 수 없습니다.")
        );
        ProductInCart productInCart = new ProductInCart();
        productInCart.setProduct(product);
        productInCart.setNums(nums);
        productInCartRepository.save(productInCart);
        cart.getProductInCartList().add(productInCart);
    }
}
