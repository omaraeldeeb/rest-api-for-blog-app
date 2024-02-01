package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByNameContaining(String name);


    List<Product> findByNameLike(String name);


    List<Product> findByPriceBetween(BigDecimal start, BigDecimal end);

    List<Product> findByDateCreatedBetween(LocalDateTime start, LocalDateTime end);

    List<Product> findByNameIn(List<String> names);


    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop3ByOrderByPriceDesc();

}
