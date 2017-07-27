package com.mycompany.catalogservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner{

    @Autowired
    ProductDocumentRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.save(Arrays.asList(
                new ProductDocument(null, "Product 1"),
                new ProductDocument(null, "Product 2"),
                new ProductDocument(null, "Product 3"),
                new ProductDocument(null, "Product 4"),
                new ProductDocument(null, "Product 5")
                ));
        System.err.println("Sample data initialized..................");
    }
}
