package com.sparta.clonekurly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "CART_ID")
    private List<ProductInCart> productInCartList;

    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    public Cart(User user){
        this.user = user;
    }


}
