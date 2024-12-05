package com.scaler.novprojectmodule.controller;

import com.scaler.novprojectmodule.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // CRUD apis around product
    // For the product
    // 1. to create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    // This will help in creating the product
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @PostMapping("/products")
    public void createProduct(Product product) {
        
    }

    // This will help in getting the product
    public Product getProductById(Long id) {
        return null;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Long id) {

    }
}
