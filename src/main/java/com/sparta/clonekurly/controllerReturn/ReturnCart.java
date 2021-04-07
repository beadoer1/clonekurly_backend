package com.sparta.clonekurly.controllerReturn;

import com.sparta.clonekurly.model.ProductInCart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ReturnCart {
    private Boolean ok;
    private List<ProductInCart> results;
}
