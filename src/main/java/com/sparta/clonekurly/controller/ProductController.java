package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.ProductRepository;
import com.sparta.clonekurly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/recommendations")
    public ReturnClass getRecommendations(){
        return productService.getRecommendations();
    }

    @GetMapping("/api/discounts")
    public ReturnClass getDiscounts(){
        return productService.getDiscounts();
    }
}