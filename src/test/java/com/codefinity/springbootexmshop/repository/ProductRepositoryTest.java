package com.codefinity.springbootexmshop.repository;

import com.codefinity.springbootexmshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = new ProductRepository();
    }

    @Test
    public void testFindByName() {
        Product foundProduct = productRepository.findByName("product1");
        assertEquals("product1", foundProduct.getName());
        assertEquals(200, foundProduct.getPrice());
    }

    @Test
    public void testFindByName_NotFound() {
        Product foundProduct = productRepository.findByName("Nonexistent Product");
        assertNull(foundProduct);
    }
}
