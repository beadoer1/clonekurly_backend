package com.sparta.clonekurly.controllerReturn;

import com.sparta.clonekurly.model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReturnProductDetail {
    private Boolean ok;
    private Product results;
}
