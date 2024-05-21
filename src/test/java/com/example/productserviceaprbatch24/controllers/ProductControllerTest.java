package com.example.productserviceaprbatch24.controllers;

import com.example.productserviceaprbatch24.exceptions.ProductLimitReachedExpection;
import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {


    @MockBean
    ProductService productService;

    @Autowired
    ProductController productController;

    @Test
    void Test_WhenGetProductByIdIsCalled_ThenReturnProduct()
            throws ProductLimitReachedExpection {
        //Arrange
        Product product = new Product();
        product.setTitle("Mackbook");
        product.setId(2L);
        //Rule
        when(productService.getProductById(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<Product> responseEntity
                = productController.getProductbyId(2l);

        //Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(2L, responseEntity.getBody().getId());
        assertEquals("Mackbook", responseEntity.getBody().getTitle());
    }
}