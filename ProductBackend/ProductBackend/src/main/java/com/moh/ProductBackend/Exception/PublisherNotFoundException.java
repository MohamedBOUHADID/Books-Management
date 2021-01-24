package com.moh.ProductBackend.Exception;

public class PublisherNotFoundException extends RuntimeException {

    public PublisherNotFoundException(String message){
        super(message);
    }
}
