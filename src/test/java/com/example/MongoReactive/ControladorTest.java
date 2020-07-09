package com.example.MongoReactive;

import com.example.MongoReactive.controller.Controlador;
import com.example.MongoReactive.repository.ProductRepository;
import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

@TestConfig
public class ControladorTest {

    @Autowired
    private Controlador controlador;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testFindPriceByNameOfProduct(){
        StepVerifier
                .create(this.controlador.precioPorNombreDelProducto("laptop"))
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
}
