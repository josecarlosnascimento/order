package br.com.jcn.repository;

import br.com.jcn.controller.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new NotFoundException(String.format("O produto com o id %d nao existe", id)));
    }
}
