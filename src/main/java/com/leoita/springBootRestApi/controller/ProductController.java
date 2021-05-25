package com.leoita.springBootRestApi.controller;

import com.leoita.springBootRestApi.model.Product;
import com.leoita.springBootRestApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    //update only needed product parameters
    @PatchMapping("/{id}")
    public Product updateProductParameter(@PathVariable("id") Long Id, @RequestBody Map<String, Object> fields) {
        Product product = productServiceImpl.getProductById(Id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key); //find the field with name equal to the key
            if (field != null) {
                field.setAccessible(true); // allow the edition of the field
                ReflectionUtils.setField(field, product, value); //set a value to the field
            }
        });
        productServiceImpl.updateProduct(product);
        return product;
    }
}
