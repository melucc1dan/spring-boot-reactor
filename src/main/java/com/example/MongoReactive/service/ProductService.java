package com.example.MongoReactive.service;

import com.example.MongoReactive.documents.NameDto;
import com.example.MongoReactive.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<NameDto> nombresDeFabricantesDeProductosEnStock(boolean stock){
        return this.productRepository
                .findProductNameByStock(stock)
                .map(factory -> new NameDto(factory.getFactory().getName()));
    }

}
