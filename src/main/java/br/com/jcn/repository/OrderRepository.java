package br.com.jcn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Orders;

import java.time.LocalDate;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Orders findByHashOrder(int hash);

}
