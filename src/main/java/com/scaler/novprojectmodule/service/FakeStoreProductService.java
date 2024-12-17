package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.dto.FakeStoreProductDto;
import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    // Inside this, fake store is going to be third party service
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("Inside FK product service");
        FakeStoreProductDto fakeStoreProductDto =
                 restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

//        System.out.println(fakeStoreProductDto.toString());

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id "+id);
        }
        return fakeStoreProductDto.getProduct();
    }

    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);
        return response.getProduct();
    }

}
