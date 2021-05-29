package com.leoita.springBootRestApi.controller;

import com.leoita.springBootRestApi.model.Product;
import com.leoita.springBootRestApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping
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
        return productServiceImpl.createOrUpdateProduct(product);
    }

    //update a product
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productServiceImpl.createOrUpdateProduct(product);
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
        return productServiceImpl.createOrUpdateProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long Id) {
        productServiceImpl.deleteProductById(Id);
        return "product with id "+ Id +" has been deleted";
    }
}
