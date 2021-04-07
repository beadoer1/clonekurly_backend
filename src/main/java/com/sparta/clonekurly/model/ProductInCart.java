package com.sparta.clonekurly.model;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class ProductInCart {

    private Long id;

    @ManyToOne
    private Product product;

    private Long nums;
}
