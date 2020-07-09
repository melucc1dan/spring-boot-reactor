package com.example.MongoReactive.exception;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "NotFoundException(404)";

    public NotFoundException(String detalle){
        super(DESCRIPTION+", "+detalle);
    }
}
