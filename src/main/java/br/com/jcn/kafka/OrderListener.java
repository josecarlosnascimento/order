package br.com.jcn.kafka;

import br.com.jcn.request.OrderRequest;
import br.com.jcn.service.ProcessOrderService;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProcessOrderService processOrderService;

	@KafkaListener(topics = "process-order", groupId = "orders")
	public void process(String message) throws JsonProcessingException {
		OrderRequest orderRequest = objectMapper.readValue(message, OrderRequest.class);
		var order = processOrderService.processOrder(orderRequest);
		if(order != null) {
			log.warn("PEDIDO PROCESSADO COM SUCESSO");
		}
	}
}
