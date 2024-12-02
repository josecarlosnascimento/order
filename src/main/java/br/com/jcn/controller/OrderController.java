package br.com.jcn.controller;

import java.util.List;

import br.com.jcn.controller.response.OrderResponse;
import br.com.jcn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcn.model.Orders;
import br.com.jcn.repository.OrderRepository;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Orders>> findAll(){
		return ResponseEntity.ok(orderService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(orderService.findById(id));
	}
}
