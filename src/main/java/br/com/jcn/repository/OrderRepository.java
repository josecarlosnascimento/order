package br.com.jcn.repository;

import br.com.jcn.controller.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jcn.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Orders findByHashOrder(int hash);

    default Orders findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new NotFoundException(String.format("O pedido com o id %d nao existe", id)));
    }

}
