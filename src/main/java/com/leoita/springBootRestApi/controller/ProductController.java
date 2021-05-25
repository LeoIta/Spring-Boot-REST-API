package com.leoita.springBootRestApi.controller;

import com.leoita.springBootRestApi.model.Product;
import com.leoita.springBootRestApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
