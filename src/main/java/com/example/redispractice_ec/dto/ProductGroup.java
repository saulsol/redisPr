package com.example.redispractice_ec.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductGroup {

    private String productGroupId;

    private List<Product> productList;
}
