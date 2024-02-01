package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;





@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product savedObject = productRepository.save(product);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }
    @Test
    void updateUsingSaveMethod (){
        Long id = 4L;
        Product product = productRepository.findById(id).get();
        product.setName("updated product 1");
        product.setDescription("updated description");

        productRepository.save(product);

    }


    @Test
    void findByIdMethod (){
        Long id = 4L;
        Product product = productRepository.findById(id).get();
        System.out.println(product);

    }

    @Test
    void saveAllMethod(){
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod (){
        List<Product> products = productRepository.findAll();


        for (Product product : products){
            System.out.println(product.getName());
        }

        System.out.println("-----------------------------------------------------");

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }


    @Test
    void deleteByIdMethod(){
        Long id = 4L;
        productRepository.deleteById(id);
    }


    @Test
    void deleteMethod (){
        Long id = 6L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }


    @Test
    void deleteAllMethod (){
        productRepository.deleteAll();

//        Product product = productRepository.findById(9L).get();
//        Product product2 = productRepository.findById(10L).get();
//        Product product3 = productRepository.findById(11L).get();
//        List<Product> products = List.of(product,product2,product3);
//        productRepository.deleteAll(products);

    }

    @Test
    void countMethod (){
        long counter = productRepository.count();
        System.out.println("The number of products in the database: " + counter);
        System.out.println(productRepository.count());
    }


    @Test
    void existByIdMethod (){
        System.out.println(productRepository.existsById(13L));
    }






}