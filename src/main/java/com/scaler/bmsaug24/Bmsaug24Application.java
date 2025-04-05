package com.scaler.bmsaug24;

import com.scaler.bmsaug24.controllers.UserController;
import com.scaler.bmsaug24.dtos.SignUpRequestDto;
import com.scaler.bmsaug24.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Bmsaug24Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Bmsaug24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    // HW : Create a show
        // Create a user
        // Make a booking

    }
}
