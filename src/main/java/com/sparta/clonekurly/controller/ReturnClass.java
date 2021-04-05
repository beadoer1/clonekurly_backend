package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ReturnClass {
    private Boolean ok;
    private List<Product> results = new ArrayList<>();
}
