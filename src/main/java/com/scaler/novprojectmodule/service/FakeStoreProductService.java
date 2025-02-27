package com.scaler.novprojectmodule.service;

import com.scaler.novprojectmodule.dto.FakeStoreProductDto;
import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    // Inside this, fake store is going to be third party service
    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("Inside FK product service");
//        Product productFromRedis = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCTS_"+id);
//        if(productFromRedis != null) {
//            return productFromRedis;
//        }

        // First part is : assume it as table name
        // Second part : key of the product
        Product redisProduct = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCTS_"+id);

        if(redisProduct != null) {
            // cache hit
            System.out.println("Inside redis");
            return redisProduct;
        }

        FakeStoreProductDto fakeStoreProductDto =
                 restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found with id "+id);
        }

        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCTS_"+id, fakeStoreProductDto.getProduct());

        return fakeStoreProductDto.getProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {


        return null;
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
