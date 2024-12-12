package com.scaler.novprojectmodule.controller;

import com.scaler.novprojectmodule.dto.ErrorDto;
import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
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
    public Product createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product.getId(),
                product.getTitle(), product.getDescription(),
                product.getPrice(), product.getCategory().getTitle());
        return p;
    }

    // This will help in getting the product
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Starting the api here");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api here");

        return p;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Long id) {

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDto handleProductNotFoundException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return errorDto;
    }
}
