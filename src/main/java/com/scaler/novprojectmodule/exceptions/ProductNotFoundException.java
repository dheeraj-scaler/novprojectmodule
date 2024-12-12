package com.scaler.novprojectmodule.exceptions;

public class ProductNotFoundException extends Exception{

    // Create an object of ProductNotFoundException class and set
    // the error message
    public ProductNotFoundException(String message) {
        super(message);
    }
}
