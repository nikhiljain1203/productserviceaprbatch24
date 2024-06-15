package com.example.productserviceaprbatch24.repos;

import com.example.productserviceaprbatch24.models.Product;
import com.example.productserviceaprbatch24.projections.ProductwithTitleandDesc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    void delete(Product product);
    @Override
    Product save(Product product); // create and update

    //HQL
    @Query("select p.title as title, p.description as description from Product p where p.id=:id")
    ProductwithTitleandDesc someRandomQuery(@Param("id") Long id);

    //SQL
    @Query(value = "select title, description from product where id = :id", nativeQuery = true)
    ProductwithTitleandDesc someRandomQuery1(@Param("id") Long id);

    List<Product> findByTitleContains(String title, Pageable pageable);
}
