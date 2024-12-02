package br.com.jcn.service;

import br.com.jcn.kafka.OrderDispatcher;
import br.com.jcn.model.OrderStatus;
import br.com.jcn.model.Orders;
import br.com.jcn.repository.CustomerRepository;
import br.com.jcn.repository.OrderRepository;
import br.com.jcn.request.OrderItensRequest;
import br.com.jcn.request.OrderRequest;
import br.com.jcn.service.utils.CustomerData;
import br.com.jcn.service.utils.ProductData;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
class ProcessOrderServiceTest {
	
	@Mock
	private ProductService productService;
	
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private OrderDispatcher orderDispatcher;

	@InjectMocks
	private ProcessOrderService processOrderService;

	@Test
	public void shouldProcessOrder() throws JsonProcessingException {
		OrderRequest orderRequest = new OrderRequest();

		OrderItensRequest firstItem = new OrderItensRequest();
		firstItem.setAmount(10);
		firstItem.setProductId(1L);

		Set<OrderItensRequest> orderItens = Set.of(firstItem);

		orderRequest.setCustomerId(1L);
		orderRequest.setOrderItens(orderItens);

		Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(CustomerData.oneCustomerData()));
		Mockito.when(productService.findById(Mockito.anyLong())).thenReturn(ProductData.oneProductData());

		Orders processOrder = processOrderService.processOrder(orderRequest);
		
		assertEquals(55.0, processOrder.getTotal());
		assertEquals(1, processOrder.getOrderItens().size());
		assertEquals(1, processOrder.getCustomer().getId());
		assertEquals(OrderStatus.CALCULADO, processOrder.getStatus());

	}
}
