package com.mycompany.orderservice;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/order/{orderId}")
	public OrderDTO getOrder(@PathVariable long orderId) {
		Order order = orderRepository.findOne(orderId);
		Set<Product> products = productRepository.findByOrder(order);

		ObjectMapper objectMapper = new ObjectMapper();
		OrderDTO orderDTO = objectMapper.convertValue(order, OrderDTO.class);

		Set<ProductDTO> productDTOs = products.stream().map(p -> convertProductToProductDTO(objectMapper, p))
				.collect(Collectors.toSet());

		orderDTO.setProducts(productDTOs);
		return orderDTO;
	}

	@RequestMapping(path = "/order", method = RequestMethod.POST)
	public Order createOrder(@RequestBody OrderDTO orderDTO) {
		ObjectMapper objectMapper = new ObjectMapper();
		Order order = objectMapper.convertValue(orderDTO, Order.class);
		Set<Product> products = orderDTO.getProducts().stream()
				.map(p -> convertProductDTOToProduct(objectMapper, order, p)).collect(Collectors.toSet());

		order.setProducts(products);

		return orderRepository.save(order);
	}

	@RequestMapping("/products")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	private Product convertProductDTOToProduct(ObjectMapper objectMapper, Order order, ProductDTO productDTO) {
		Product product = objectMapper.convertValue(productDTO, Product.class);
		product.setOrder(order);
		return product;
	}

	private ProductDTO convertProductToProductDTO(ObjectMapper objectMapper, Product product) {
		return objectMapper.convertValue(product, ProductDTO.class);
	}

}
