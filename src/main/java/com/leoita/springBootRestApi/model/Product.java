package com.leoita.springBootRestApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class Product {
    private long Id;
    private String name;
    private double price;

}
