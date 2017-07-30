package com.mycompany.orderservice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "orders")
@ToString
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long customerId;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products;
	
	private String status;
	
	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setOrder(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setOrder(null);

		return product;
	}
	
}
