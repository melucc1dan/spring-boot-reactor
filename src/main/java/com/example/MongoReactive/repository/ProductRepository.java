package com.example.MongoReactive.repository;

import com.example.MongoReactive.documents.FactoryDto;
import com.example.MongoReactive.documents.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface ProductRepository extends ReactiveSortingRepository<Product, String> {

    Mono<Product> findByName(String productsName);

    Flux<Product> findByPriceGreaterThan(int price);

    @Query(value="{'name':?0}", fields = "{'_id':0, 'factory':1}")
    Flux<FactoryDto> findFactoryByName(String name);

    @Query(value="{'stock':?0}", fields = "{'_id':0, 'factory.name':1}")
    Flux<FactoryDto> findProductNameByStock(boolean stock);

}
