package br.com.jcn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
