package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Category;
import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.repository.CategoryRepository;
import com.scaler.novprojectmodule.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(id);

        if (p.isPresent()) {
            return p.get();
        }

        throw new ProductNotFoundException("Product is not found in our database");
    }

    @Override
    public List<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {
//        Page<Product> products = productRepository.findAll(PageRequest.of(pageNumber, pageSize,
//                Sort.by(fieldName).ascending()));
//
//        return products;
        return null;
    }


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String categoryTitle) {

        // 1. Check is category is there in db
        // 2. If not there, create it and use it while saving product
        // 3. If there , use it in product directly
        Product p = new Product();
        Optional<Category> currentCat = categoryRepository.findByTitle(categoryTitle);
        if(currentCat.isEmpty()) {
            // This means category is not present in our db
            Category newCat = new Category();
            newCat.setTitle(categoryTitle);
            Category newRow = categoryRepository.save(newCat);
            p.setCategory(newRow);
        } else {
            Category currentCategory = currentCat.get();
            p.setCategory(currentCategory);
        }
        p.setTitle(title);
        p.setDescription(description);
//        p.setImageUrl(im);
        p.setPrice(price);
        Product savedproduct = productRepository.save(p);

        return savedproduct;
    }
}
