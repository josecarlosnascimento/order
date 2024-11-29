package br.com.jcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jcn.controller.response.ProductResponse;
import br.com.jcn.model.Product;
import br.com.jcn.repository.ProductRepository;
import br.com.jcn.service.ProductService;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(productRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(productService.findProductById(id));
	}
	
}
