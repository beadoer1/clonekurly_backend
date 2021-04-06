package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.ProductRepository;
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

    @GetMapping("/api/recommendations")
    public ReturnClass getRecommendation(){
        ReturnClass returnClass = new ReturnClass();
        List<Product> productList = productRepository.findAll();
        returnClass.setOk(true);
        returnClass.setResults(productList);
        return returnClass;
    }

    @GetMapping("/api/recommendation")
    public Product getRecommend(){
        Product product = productRepository.findByNo(460L);
        return product;
    }

    @ResponseBody
    @GetMapping("/api/test")
    public String testapi(){
        String str = "연결 성공";
        return str;
    }

//    @GetMapping("/api/discounts")
//    public ReturnClass getDiscounts(){
//        ReturnClass returnClass = new ReturnClass();
//        List<Product> productList = productRepository.findByDiscounted_priceGreaterThan(0L, PageRequest.of(1, 6));
//        returnClass.setOk(true);
//        returnClass.setResults(productList);
//        return returnClass;
//    }

}
