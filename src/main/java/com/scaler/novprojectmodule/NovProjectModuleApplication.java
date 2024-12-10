package com.scaler.novprojectmodule;

import com.scaler.novprojectmodule.models.Product;
import com.scaler.novprojectmodule.service.FakeStoreProductService;
import com.scaler.novprojectmodule.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovProjectModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovProjectModuleApplication.class, args);

//        Product p = new Product();
//        p.setId(12L);
//        System.out.println(p);


    }


}

//Product{id=12, title='null',
//        description='null',
//        price=null, imageUrl='null', category=null}

