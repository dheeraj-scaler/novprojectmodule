package com.scaler.novprojectmodule.controller;

import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Category;
import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.repository.CategoryRepository;
import com.scaler.novprojectmodule.repository.ProductRepository;
import com.scaler.novprojectmodule.repository.projections.ProductProjection;
import com.scaler.novprojectmodule.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class ProductControllerTesting {


    @MockitoBean
//    @Mock
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    void getProductByIdPositiveCaseTest() throws ProductNotFoundException {

        Product p = new Product();
        p.setId(10L);
        p.setTitle("Tshirts");

        System.out.println("Breakpoint 1");

        // Whenever someone is calling productService . getSingleProduct (10)
        // In that scenario, you need to return the above dummy product we created
        when(productService.getSingleProduct(anyLong()))
                .thenReturn(p);

        Product p1 = productController.getProductById(20L).getBody();

        System.out.println("Breakpoint 2");
        System.out.println(p1.getTitle());
        assertEquals(p.getTitle(), p1.getTitle());
        assertEquals(p, p1);



        // If I call the controller with id = 10,
        //
    }



    @Test
    void getProductByIdNegativeCaseTest() throws ProductNotFoundException {

        when(productService.getSingleProduct(11L)).thenThrow(ProductNotFoundException.class);

        assertThrows(
                ProductNotFoundException.class,
                () -> productController.getProductById(11L)
        );
    }

    @Test
    void getAllProductsTesting() {

        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("shorts");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("shirts");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("tshirts");

        Product p4 = new Product();
        p4.setId(4L);
        p4.setTitle("jeans");

        List<Product> dummyList = new ArrayList<>();
        dummyList.add(p1);
        dummyList.add(p2);
        dummyList.add(p3);
        dummyList.add(p4);

        // 0,0,xyz
        when(productService.getAllProducts(0,0,"xyz"))
                .thenReturn(dummyList);

        List<Product> currentProd = productController.getAllProducts(0,0,"xyz", "");

        assertEquals(4, currentProd.size());


    }

    // test this for create product and update product as a hw
}
