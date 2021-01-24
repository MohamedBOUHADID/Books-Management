package com.moh.ProductBackend.Exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message){
        super(message);
    }
}
