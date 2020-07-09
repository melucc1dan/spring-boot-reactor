package com.example.MongoReactive.documents;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class NameDto {
    public String name;

    public NameDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
