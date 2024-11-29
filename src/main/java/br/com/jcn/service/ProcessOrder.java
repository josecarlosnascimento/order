package br.com.jcn.service;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcn.kafka.OrderDispatcher;
import br.com.jcn.model.Order;
import br.com.jcn.model.OrderItens;
import br.com.jcn.repository.CustomerRepository;
import br.com.jcn.repository.OrderRepository;
import br.com.jcn.request.OrderRequest;

@Service
public class ProcessOrder {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDispatcher orderDispatcher;
	
	public Order processOrder(OrderRequest orderRequest) {
		
		Order order = new Order();
		Set<OrderItens> itens = Set.of();
		
		var customer = this.customerRepository.findById(orderRequest.getCustomerId()).get();
		orderRequest.getOrderItens().forEach(orderItem -> {
			
			var product = productService.findById(orderItem.getProductId());
			
			OrderItens item = new OrderItens();
			item.setProduct(product);
			item.setAmount(orderItem.getAmount());
			item.setTotal(BigDecimal.valueOf(product.getUnitPrice().doubleValue() * orderItem.getAmount()));
			itens.add(item);
			
		});
		
		double total = itens.stream().mapToDouble(item -> item.getTotal().doubleValue()).sum();

		order.setCustumer(customer);
		order.setOrderItens(itens);
		order.setTotal(BigDecimal.valueOf(total));
		
		
		orderRepository.save(order);
		
		orderDispatcher.send(null);
		
		return order;
	}

}
