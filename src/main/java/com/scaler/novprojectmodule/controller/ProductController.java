package com.scaler.novprojectmodule.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.novprojectmodule.dto.ErrorDto;
import com.scaler.novprojectmodule.dto.SendEmailDto;
import com.scaler.novprojectmodule.exceptions.ProductNotFoundException;
import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    // CRUD apis around product
    // For the product
    // 1. to create a product
    // 2. get a product
    // 3. update a product
    // 4. delete a product

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    private ProductService productService;
    List<Product> products = new ArrayList<>();

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Starting the api here");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api here");

        ResponseEntity<Product> response = new ResponseEntity<>(
            p, HttpStatus.OK
        );

        return response;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(Long id) {

    }

    // pageSize, pageNumber, fieldName, sort Order
    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize")int pageSize, @RequestParam("fieldName")String fieldName, @RequestParam("searchQuery") String searchQuery) {
        return productService.getAllProducts(pageNumber,pageSize, fieldName);
    }




    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody SendEmailDto sendEmailDto) {
        System.out.println(sendEmailDto.getFrom());
        String message = "Email sent";
        ResponseEntity<String> response = new ResponseEntity<>(
                message, HttpStatus.OK
        );


        try {
            kafkaTemplate.send(
                    "sendEmail",
                    objectMapper.writeValueAsString(sendEmailDto)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response;
    }


}

//serialize the information
//deserilaize the info
