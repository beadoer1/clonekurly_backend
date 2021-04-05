package com.sparta.clonekurly.service;


import com.sparta.clonekurly.controller.ReturnClass;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ReturnClass getRecommendations() {
        ReturnClass returnClass = new ReturnClass();
        List<Product> productList = productRepository.findAll();
        returnClass.setOk(true);
        returnClass.setResults(productList);
        return returnClass;
    }

    public ReturnClass getDiscounts(){
        ReturnClass returnClass = new ReturnClass();
        List<Product> productList = productRepository.findAll();
        for(int i = productList.size()-1; i >= 0; i--){
            System.out.println(i);
            Product checkVal = productList.get(i);
            if(checkVal.getDiscount_percent().equals(0L)){
                productList.remove(i);
            }
        }
        returnClass.setOk(true);
        returnClass.setResults(productList);
        return returnClass;
    }
}
