package com.example.productserviceaprbatch24.services;

import com.example.productserviceaprbatch24.models.Category;
import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.repos.CategoryRepo;
import com.example.productserviceaprbatch24.repos.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()) {
            throw new EntityNotFoundException("ProductNot Found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category= product.getCategory();
        if(category.getId() == null) {
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        }
        // categoryRepo.findByTitle(product.getCategory().getTitle())
        product.setCreatedAt("11th May");
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }
}
