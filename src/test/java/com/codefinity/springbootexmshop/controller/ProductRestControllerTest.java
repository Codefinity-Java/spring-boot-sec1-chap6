package com.codefinity.springbootexmshop.controller;

import com.codefinity.springbootexmshop.model.Product;
import com.codefinity.springbootexmshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductRestController.class)
@ExtendWith(MockitoExtension.class)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testFindProductByName_whenProductExists_shouldReturnProductDetails() throws Exception {
        Product product = new Product("product1", 100);
        when(productService.getProductByName("product1")).thenReturn(product);

        mockMvc.perform(get("/find").param("name", "product1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("product1"))
                .andExpect(jsonPath("$.price").value(100));

        verify(productService).getProductByName("product1");
    }
}
