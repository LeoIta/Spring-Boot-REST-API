package com.leoita.springBootRestApi.service;

import com.leoita.springBootRestApi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();
    Product getProductById(Long Id);
    Product createOrUpdateProduct(Product product);
    void deleteProductById(Long Id);
}