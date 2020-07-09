package com.example.MongoReactive.documents;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@JsonInclude
public class Product {

    @Id
    private String id;
    private String name;
    private long price;
    private boolean stock;
    private Factory factory;

    public Product() {
    }

    public Product(String id, String name, long price, boolean stock, Factory factory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.factory = factory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
