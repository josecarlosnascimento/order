package br.com.jcn.kafka;

import br.com.jcn.model.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDispatcher {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void send(Orders order) throws JsonProcessingException {
		var message = objectMapper.writeValueAsString(order);
		kafkaTemplate.send("order-dispatcher", message);
	}
}
