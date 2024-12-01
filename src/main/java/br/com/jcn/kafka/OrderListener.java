package br.com.jcn.kafka;

import br.com.jcn.request.OrderRequest;
import br.com.jcn.service.ProcessOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProcessOrderService processOrderService;

	@KafkaListener(topics = "process-order", groupId = "orders")
	public void process(String message) throws JsonProcessingException {
		OrderRequest order = objectMapper.readValue(message, OrderRequest.class);
		processOrderService.processOrder(order);
	}
}
