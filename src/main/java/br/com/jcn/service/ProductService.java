package br.com.jcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.jcn.controller.response.ProductResponse;
import br.com.jcn.model.Product;
import br.com.jcn.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
    @Cacheable(value = "products", key = "#productId")
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("O produto com o id % nao existe", id)));
	}
    
    public ProductResponse findProductById(Long id) {
    	var product = findById(id);
		return new ProductResponse(id, product.getName(), product.getUnitPrice());
    }
}
