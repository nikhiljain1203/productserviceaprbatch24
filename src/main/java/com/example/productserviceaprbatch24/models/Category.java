package com.example.productserviceaprbatch24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String title;
    @OneToMany
    private List<Product> productList;
}

// fetch query select * from category join
// Select * from product where category_id = id
