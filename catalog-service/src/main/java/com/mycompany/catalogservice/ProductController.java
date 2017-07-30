package com.mycompany.catalogservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDocumentRepository productDocumentRepository;
	
	@RequestMapping("/myproducts")
	public List<ProductDocument> getProducts() {
		return productDocumentRepository.findAll();
	}

}
