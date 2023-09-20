package com.example.project.dvaraecommerce.exception;

public class ProductNotFoundException extends RuntimeException {
   
    public ProductNotFoundException(String message) {
        super(message);
    }
}