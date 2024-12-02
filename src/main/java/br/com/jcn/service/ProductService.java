package br.com.jcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.jcn.controller.response.ProductResponse;
import br.com.jcn.model.Product;
import br.com.jcn.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
    @Cacheable(value = "products", key = "#id")
	public Product findById(Long id) {
		return productRepository.findByIdOrElseThrow(id);
	}

	public List<ProductResponse> findAll() {
		return productRepository.findAll().stream().map(p -> new ProductResponse(p.getId(), p.getName(), p.getUnitPrice())).toList();
	}
    
    public ProductResponse findProductById(Long id) {
    	var product = findById(id);
		return new ProductResponse(id, product.getName(), product.getUnitPrice());
    }
}
