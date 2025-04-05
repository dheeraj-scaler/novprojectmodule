package com.scaler.bmsaug24.controllers;

import com.scaler.bmsaug24.dtos.SignUpRequestDto;
import com.scaler.bmsaug24.dtos.SignUpResponseDto;
import com.scaler.bmsaug24.models.User;
import com.scaler.bmsaug24.services.UserService;
import org.springframework.stereotype.Controller;

public class UserController {


    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    SignUpResponseDto signUpUser(SignUpRequestDto requestDto) {
        // call the user service sign up

        return null;
    }
}
