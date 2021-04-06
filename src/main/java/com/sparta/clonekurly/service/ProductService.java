package com.sparta.clonekurly.service;


import com.sparta.clonekurly.controllerReturn.ReturnProduct;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ReturnProduct getRecommendations() {
        ReturnProduct returnProduct = new ReturnProduct();
        List<Product> productList = productRepository.findAll();
        returnProduct.setOk(true);
        returnProduct.setResults(productList);
        return returnProduct;
    }

    public ReturnProduct getDiscounts(){
        ReturnProduct returnProduct = new ReturnProduct();
        List<Product> productList = productRepository.findAll();
        for(int i = productList.size()-1; i >= 0; i--){
            System.out.println(i);
            Product checkVal = productList.get(i);
            if(checkVal.getDiscount_percent().equals(0L)){
                productList.remove(i);
            }
        }
        returnProduct.setOk(true);
        returnProduct.setResults(productList);
        return returnProduct;
    }
}
