package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts(int pageNumber, int pageSize, String fieldName);

    Product createProduct(Long id, String title, String description, Double price, String category);
}
