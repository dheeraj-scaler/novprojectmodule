package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    // Inside this, fake store is going to be third party service

    public Product getSingleProduct(long id) {
        System.out.println("We are in single product method");
        return null;
    }

    public List<Product> getAllProducts() {
        return List.of();
    }

    public Product createProduct(Product product) {
        return null;
    }
}
