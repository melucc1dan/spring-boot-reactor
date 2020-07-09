package com.example.MongoReactive.controller;

import com.example.MongoReactive.documents.FactoryDto;
import com.example.MongoReactive.documents.NameDto;
import com.example.MongoReactive.documents.Product;
import com.example.MongoReactive.exception.NotFoundException;
import com.example.MongoReactive.repository.ProductRepository;
import com.example.MongoReactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Controlador {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/productosDeMayorPrecioA")
    public Flux<Product> productosDeMayorPrecioA(@RequestParam int price){
        return productRepository.findByPriceGreaterThan(price);
    }

    @GetMapping("/allProducts")
    public Flux<Product> listaCompletoDeProductos(){
        return productRepository.findAll();
    }

    @GetMapping("/productosEnStock")
    public Flux<Product> listadoDeProductosEnStock(){
        return productRepository.findAll().filter(Product::isStock);
    }

    @GetMapping("/priceOfProduct")
    public Mono<Long> precioPorNombreDelProducto(@RequestParam String productsName){
        return productRepository
                .findByName(productsName)
                .switchIfEmpty(Mono.error(new NotFoundException("Producto No encontrado")))
                .map(Product::getPrice);
    }

    @GetMapping("/nombreFabricante")
    public Mono<String> nombreDelFabricanteDelProducto(@RequestParam String productsName){
        return productRepository
                .findByName(productsName)
                .switchIfEmpty(Mono.error(new NotFoundException("Producto No Encontrado")))
                .map(s -> s.getFactory().getName());
    }

    @GetMapping("/precioTotal")
    public Mono<Integer> sumatoriaTotalPreciosDeProductos(){
        return productRepository
                .findAll()
                .map(Product::getPrice)
                .reduce(0,(x1, x2) -> Math.toIntExact(x1 + x2));
    }

    @GetMapping("/fabricanteDe")
    public Flux<FactoryDto> nombreFabricanteDelProducto(@RequestParam String nombreProducto){
        return productRepository.findFactoryByName(nombreProducto);
    }

    @GetMapping("/fabricantesDeProductosEnStock")
    public Flux<NameDto> nombresFabricantes(@RequestParam boolean stock){
        return productService.nombresDeFabricantesDeProductosEnStock(stock);
    }
}
