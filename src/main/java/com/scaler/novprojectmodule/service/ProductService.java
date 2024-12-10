package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product createProduct(Long id, String title, String description, Double price, String category);
}
