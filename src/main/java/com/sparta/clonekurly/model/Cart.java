package com.sparta.clonekurly.model;

import javax.persistence.*;
import java.util.List;

public class Cart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @OneToMany
    private List<ProductInCart> productInCart;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private Users user;
}
