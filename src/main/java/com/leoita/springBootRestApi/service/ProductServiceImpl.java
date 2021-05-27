package com.leoita.springBootRestApi.service;

import com.leoita.springBootRestApi.model.Product;
import com.leoita.springBootRestApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public Product getProductById(Long Id) {
        return productRepository.findById(Id).orElse(null);
    }

    public void createOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Long Id) {
        productRepository.deleteById(Id);
    }
}