package com.mycompany.orderservice;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	private long id;
	private long customerId;
	
	private Set<ProductDTO> products;
	
	private String status;
	
}
