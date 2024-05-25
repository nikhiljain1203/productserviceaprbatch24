package com.example.productserviceaprbatch24.controllers;

import com.example.productserviceaprbatch24.exceptions.ProductLimitReachedExpection;
import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.services.ProductService;
import com.example.productserviceaprbatch24.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
    Get - Getting a product
    Delete - Delete a product
    Post - Create a product
    Put - Replace a product
    Patch - Updating a product

    Get product - modify - put
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private TokenService tokenService;

    ProductController(ProductService productService, TokenService tokenService) {
        this.productService = productService;
        this.tokenService = tokenService;
    }

    @GetMapping("/{id}")
    //Ideally should return a Product DTO
    public ResponseEntity<Product> getProductbyId(@RequestHeader("token") String token, @PathVariable("id") Long id){
        if(!tokenService.validateToken(token)) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductbyId(@PathVariable("id") Long id) {
        return new Product();
    }

//    @ExceptionHandler({RuntimeException.class, NullPointerException.class})
//    public ResponseEntity<String> handleException() {
//        System.out.println("Something went Wrong");
//        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public ResponseEntity<String> handleIndexException() {
//        System.out.println("Something went Wrong");
//        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
//    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleIndexException() {
//        System.out.println("Something Wrong");
//        return new ResponseEntity<>("Something Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
