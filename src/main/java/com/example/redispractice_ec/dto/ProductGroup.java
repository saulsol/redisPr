package com.example.redispractice_ec.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductGroup {

    private String productGroupId; // FPG0001

    private List<Product> productList;
}
