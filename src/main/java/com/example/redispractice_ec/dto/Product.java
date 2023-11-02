package com.example.redispractice_ec.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private String productGroupId; // PG0001

    private String productId; // []

    private int price;

}
