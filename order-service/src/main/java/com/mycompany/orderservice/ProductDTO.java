package com.mycompany.orderservice;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String productId;
	
	@JsonIgnore
	private Order order;
	
	private int quantity;

}
