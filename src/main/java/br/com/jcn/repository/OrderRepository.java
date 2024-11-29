package br.com.jcn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
