package com.codefinity.springbootexmshop.service;

import com.codefinity.springbootexmshop.model.Product;
import com.codefinity.springbootexmshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductByName() {
        Product product = new Product("Test Product", 100);
        when(productRepository.findByName("Test Product")).thenReturn(product);

        Product foundProduct = productService.getProductByName("Test Product");
        assertEquals("Test Product", foundProduct.getName());
        assertEquals(100, foundProduct.getPrice());
    }
}