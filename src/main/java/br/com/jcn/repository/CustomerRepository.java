package br.com.jcn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
