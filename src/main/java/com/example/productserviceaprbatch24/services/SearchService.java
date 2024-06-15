package com.example.productserviceaprbatch24.services;

import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.repos.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> search(String keyword, int pageNumber, int pageSize) {
        return productRepo.findByTitleContains(keyword, PageRequest.of(pageNumber, pageSize));
    }
}
