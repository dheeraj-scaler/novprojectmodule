package com.scaler.novprojectmodule.controller;

import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    // CRUD apis around product
    // For the product
    // 1. to create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // This will help in creating the product
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @PostMapping("/products")
    public void createProduct(Product product) {
        
    }

    // This will help in getting the product
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        productService.getSingleProduct(id);
        return null;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Long id) {

    }
}
