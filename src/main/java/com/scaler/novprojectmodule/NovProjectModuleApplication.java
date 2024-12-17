package com.scaler.novprojectmodule;

import com.scaler.novprojectmodule.controller.ProductController;
import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.service.FakeStoreProductService;
import com.scaler.novprojectmodule.service.ProductService;
import com.scaler.novprojectmodule.service.SelfProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NovProjectModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovProjectModuleApplication.class, args);

//        Product p = new Product();
//        p.setId(12L);
//        System.out.println(p);
//        ProductService productService = new SelfProductService();
//        ProductController pc = new ProductController(productService);
    }
}

//Product{id=12, title='null',
//        description='null',
//        price=null, imageUrl='null', category=null}

