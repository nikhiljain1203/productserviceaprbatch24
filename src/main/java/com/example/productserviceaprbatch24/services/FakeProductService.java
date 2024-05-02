package com.example.productserviceaprbatch24.services;

import com.example.productserviceaprbatch24.dtos.FakeStoreProductDto;
import com.example.productserviceaprbatch24.models.Category;
import com.example.productserviceaprbatch24.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService {

    private RestTemplate restTemplate;

    FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        return convertDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }

    // Converts a FakeStoreProductDto to a Product object
    private Product convertDtoToProduct(FakeStoreProductDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Assuming Category needs only id and title, and title is derived from category field of DTO
        Category category = new Category();
        // Here you would assign the id and title of the category appropriately.
        // For demonstration, let's assume the category title is what's passed in the DTO
        // and we set a dummy ID or fetch the correct ID based on the title from a database or other source.
        category.setId(0); // Dummy ID or retrieve appropriately
        category.setTitle(dto.getCategory());

        product.setCategory(category);

        return product;
    }
}
