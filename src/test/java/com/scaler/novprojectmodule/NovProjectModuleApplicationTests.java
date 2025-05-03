package com.scaler.novprojectmodule;

import com.scaler.novprojectmodule.models.Category;
import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.repository.CategoryRepository;
import com.scaler.novprojectmodule.repository.ProductRepository;
import com.scaler.novprojectmodule.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NovProjectModuleApplicationTests {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

    @Test
    void fetchTypeTest() {
//        Category cat = categoryRepository.findById(1L).get();
//        System.out.println(cat.getId());
//        System.out.println("We are done here");
//
//        List<Product> currentProduct = cat.getProducts();
//        System.out.println(currentProduct.size());
//
//        System.out.println("We got the products as well");


       // HW , try to create a scenario for N+1
        // Hint : Fetch list of category
        // Iterate and try to do getProduct()
        assertEquals(1,1);
    }

}
