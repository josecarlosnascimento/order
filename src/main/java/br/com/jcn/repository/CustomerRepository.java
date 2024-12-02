package br.com.jcn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.controller.exception.NotFoundException;
import br.com.jcn.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    default Customer findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new NotFoundException(String.format("O cliente com o id %d nao existe", id)));
    }
	
}
