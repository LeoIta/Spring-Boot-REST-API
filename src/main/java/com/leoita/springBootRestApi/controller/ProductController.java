package com.leoita.springBootRestApi.controller;

import com.leoita.springBootRestApi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;
}
