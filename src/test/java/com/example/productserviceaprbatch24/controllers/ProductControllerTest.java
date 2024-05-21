package com.example.productserviceaprbatch24.controllers;

import com.example.productserviceaprbatch24.exceptions.ProductLimitReachedExpection;
import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.services.FakeProductService;
import com.example.productserviceaprbatch24.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
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
    //FakeProductService productService;


    @Autowired
    ProductController productController;

    @BeforeEach
    void setup() {
        Product product = new Product();
        product.setTitle("Mackbook");
        product.setId(2L);
        //Rule
        when(productService.getProductById(any(Long.class))).thenReturn(product);
    }

    @Test
    void Test_WhenGetProductByIdIsCalled_ThenReturnProduct()
            throws ProductLimitReachedExpection {
        //Arrange

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

    @Test
    void Test_WhenGetProductByIdIsCalled_ReturnException(){
        //Rule
        when(productService.getProductById(any(Long.class)))
                .thenThrow(new RuntimeException("Something went wrong"));

        assertThrows(RuntimeException.class, () -> productController.getProductbyId(2L));
    }

//    @Test
//    void Test_WhenGetProductByIdIsCalled_ThenCallRealProductService()
//            throws ProductLimitReachedExpection {
//        when(productService.getProductById(any(Long.class))).thenCallRealMethod();
//        //Act
//        ResponseEntity<Product> responseEntity
//                = productController.getProductbyId(2l);
//
//        //Assert
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertEquals(2L, responseEntity.getBody().getId());
//        assertEquals("Mackbook", responseEntity.getBody().getTitle());
//    }
}