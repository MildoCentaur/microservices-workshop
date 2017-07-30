package com.mycompany.orderservice;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	public Set<Product> findByOrder(Order order);

}
