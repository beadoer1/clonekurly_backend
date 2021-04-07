package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnProduct;
import com.sparta.clonekurly.controllerReturn.ReturnProductDetail;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.ProductRepository;
import com.sparta.clonekurly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/recommendations")
    public ReturnProduct getRecommendations(){
        return productService.getRecommendations();
    }

    @GetMapping("/api/discounts")
    public ReturnProduct getDiscounts(){
        return productService.getDiscounts();
    }

    @GetMapping("/api/products/{id}")
    public ReturnProductDetail getProductById(@PathVariable Long id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("상품 ID가 존재하지 않습니다.")
        );
        ReturnProductDetail returnProductDetail = new ReturnProductDetail();
        returnProductDetail.setOk(true);
        returnProductDetail.setResults(product);
        return returnProductDetail;
    }
}
