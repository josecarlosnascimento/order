package br.com.jcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcn.model.Orders;
import br.com.jcn.repository.OrderRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public ResponseEntity<List<Orders>> findAll(){
		return ResponseEntity.ok(orderRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orders> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(orderRepository.findById(id).get());
	}

}
