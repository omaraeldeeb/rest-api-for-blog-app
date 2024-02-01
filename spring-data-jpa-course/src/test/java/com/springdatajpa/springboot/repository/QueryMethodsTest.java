package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(3L).get();
        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository
                .findByNameOrDescription("product 1", "Product 2 description");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository
                .findByNameAndDescription("product 1", "Product 1 description");

        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }


    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product);
    }


    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }


    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(300));
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }


    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }


    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(50), new BigDecimal(250));

        for (Product product : products) {
            System.out.println(product);
        }
    }


    @Test
    void findByDateCreatedBetweenMethod(){

        LocalDateTime start = LocalDateTime.of(2023,12,29,1,31,13);
        LocalDateTime end = LocalDateTime.of(2023,12,29,1,31,30);

        List<Product> products = productRepository.findByDateCreatedBetween(start, end);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 3"));
        for (Product product : products) {
            System.out.println(product);
        }
    }



    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    void findTop3ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        for (Product product : products) {
            System.out.println(product);
        }
    }


}