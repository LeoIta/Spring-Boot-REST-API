package com.leoita.springBootRestApi.controller;

import com.leoita.springBootRestApi.model.Product;
import com.leoita.springBootRestApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    //get all the products
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getProducts() {
        return productServiceImpl.getProductList();
    }

    //get one specific product
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long Id) {
        return productServiceImpl.getProductById(Id);
    }

    //create new product
    @PostMapping()
    public Product newProduct(@RequestBody Product product) {
        productServiceImpl.createProduct(product);
        return product;
    }

    //update a product
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        productServiceImpl.updateProduct(product);
        return product;
    }
}
