package com.leoita.springBootRestApi.service;

import com.leoita.springBootRestApi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        products.add(new Product(1L, "keyboard", 14.99));
        products.add(new Product(2L, "mouse", 24.99));
        products.add(new Product(3L, "screen", 184.99));
    }

    public List<Product> getProductList() {
        return this.products;
    }

    public Product getProductById(Long Id) {
        return products.stream()
                .filter(product -> product.getId() == Id)
                .findFirst().orElse(null);
    }
}
