package com.scaler.novprojectmodule.repository;

import com.scaler.novprojectmodule.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Save

    // Get

    // Get all

    // delete

    // update

    // This will insert product records in my product table
    Product save(Product product);

    // select * from product where title = title;
    Product findByTitle(String title);

    // Create a query like this "Select * from product where description = description;"
    Product findByDescription(String description);
}