package com.scaler.novprojectmodule;

import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.repository.ProductRepository;
import com.scaler.novprojectmodule.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NovProjectModuleApplicationTests {


    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQueries() {
//        List<Product> allProducts = productRepository.getProductByCategoryIdNativeQueries(1L);
//
//        for (Product product : allProducts) {
//            System.out.println(product);
//        }

        List<ProductProjection> productProjectionList = productRepository.getProductByCategoryIdUsingProjections(1L);
        System.out.println(productProjectionList.get(0).getTitle());

    }

}
