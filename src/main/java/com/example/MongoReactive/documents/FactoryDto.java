package com.example.MongoReactive.documents;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class FactoryDto {

    private Factory factory;

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

}
