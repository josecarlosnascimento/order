package br.com.jcn.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jcn.kafka.OrderDispatcher;
import br.com.jcn.model.Orders;
import br.com.jcn.model.OrderItens;
import br.com.jcn.repository.CustomerRepository;
import br.com.jcn.repository.OrderRepository;
import br.com.jcn.request.OrderRequest;

@Service
public class ProcessOrderService {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDispatcher orderDispatcher;
	
	public Orders processOrder(OrderRequest orderRequest) {
		
		Orders orders = new Orders();
		Set<OrderItens> itens = new HashSet<>();
		
		var customer = this.customerRepository.findById(orderRequest.getCustomerId())
				.orElseThrow(() -> new RuntimeException(String.format("O cliente com o id % nao existe", orderRequest.getCustomerId())));

		orderRequest.getOrderItens().forEach(orderItem -> {
			
			var product = productService.findById(orderItem.getProductId());

			if(!isOrderDuplicated(orderRequest.getCustomerId(), orderItem.getProductId(), orderItem.getAmount())){
				OrderItens item = new OrderItens();
				item.setProduct(product);
				item.setAmount(orderItem.getAmount());
				item.setOrders(orders);
				item.setTotal(BigDecimal.valueOf(product.getUnitPrice().doubleValue() * orderItem.getAmount()));

				itens.add(item);
			}
		});
		
		double total = itens.stream().mapToDouble(item -> item.getTotal().doubleValue()).sum();

		orders.setCustumer(customer);
		orders.setOrderItens(itens);
		orders.setTotal(total);
		orders.setHashOrder(orders.hashCode());

		System.out.println(orders);
		orderRepository.save(orders);

		return orders;
	}

	private boolean isOrderDuplicated(Long customerId, Long productId, int amount){
		var hashProduct = Objects.hash(customerId, productId, amount, LocalDate.now());
		var ordersMake = orderRepository.findByHashOrder(hashProduct);
		return ordersMake.equals(hashProduct);
	}

}
