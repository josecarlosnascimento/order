package br.com.jcn.service;


import br.com.jcn.controller.response.OrderItensResponse;
import br.com.jcn.controller.response.OrderResponse;
import br.com.jcn.model.Orders;
import br.com.jcn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

    public OrderResponse findById(Long id){
        var order = orderRepository.findByIdOrElseThrow(id);
        var itens = order.getOrderItens().stream().map(o -> new OrderItensResponse(o.getProduct().getName(),
                o.getProduct().getUnitPrice(),
                o.getAmount(),
                o.getTotal())).toList();

        return new OrderResponse(order.getId(),
                                    order.getCustomer().getName(),
                                    order.getTotal(),
                                    order.getStatus(),
                                    itens);
    }
}