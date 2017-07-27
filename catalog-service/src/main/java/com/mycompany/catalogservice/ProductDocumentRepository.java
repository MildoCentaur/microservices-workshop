package com.mycompany.catalogservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/products", rel = "/products")
public interface ProductDocumentRepository extends MongoRepository<ProductDocument, String > {

}
