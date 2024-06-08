package com.example.productserviceaprbatch24.controllers;

import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @Test
//    public void testGetProductById() throws Exception {
//        Product product = new Product();
//        product.setId(1L);
//        product.setTitle("Test Product");
//        product.setDescription("This is a test product.");
//        product.setPrice(10.0);
//
//        when(productService.getProductById(any())).thenReturn(product);
//
////        mockMvc.perform(get("/products/1")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.title").value("Test Product"))
////                .andExpect(jsonPath("$.description").value("This is a test product."))
////                .andExpect(jsonPath("$.price").value(10.0));
//    }

    // Assignment -Ve & EDGE TestCases
}
