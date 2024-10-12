package com.codefinity.springbootexmshop.controller;

import com.codefinity.springbootexmshop.model.Product;
import com.codefinity.springbootexmshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    //TODO: Endpoint GET - url `/find`
    public Product findProductByName(@RequestParam String name) {
        //TODO: Realize the logic of getting the `Product` by name from the service
        return null;
    }
}


