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
import java.util.List;
import java.util.Map;

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
    public void plusProductToCart(User user, Long productId, Long nums) {
        Cart cart = cartRepository.findByUser(user);
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 상품을 찾을 수 없습니다.")
        );
        List<ProductInCart> productList = cart.getProductInCartList();
        for (ProductInCart productInCart : productList) {
            if (productInCart.getProduct().getId().equals(productId)) {
                productInCart.setNums(productInCart.getNums() + nums);
                return;
            }
        }

        ProductInCart productInCart = new ProductInCart();
        productInCart.setProduct(product);
        productInCart.setNums(nums);
        productInCartRepository.save(productInCart);
        cart.getProductInCartList().add(productInCart);
    }

    @Transactional
    public void updateProductInCart(List<Map<String,Long>> requestData){
        for (Map<String, Long> requestMap : requestData) {
            Long id = requestMap.get("id");
            Long nums = requestMap.get("nums");
            ProductInCart productInCart = productInCartRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("장바구니에 없는 상품입니다.")
            );
            productInCart.setNums(nums);
        }
    }
}
