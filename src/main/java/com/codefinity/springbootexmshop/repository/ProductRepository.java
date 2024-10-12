package com.codefinity.springbootexmshop.repository;

import com.codefinity.springbootexmshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>(
            List.of(
                    new Product("product1",200),
                    new Product("product2", 100),
                    new Product("product3", 300)
            )
    );

    public List<Product> findAllProduct() {
        return products;
    }

    public Product findByName(String name){
        //TODO: Find `Product` by name in `products`
        return null;
    }
}
