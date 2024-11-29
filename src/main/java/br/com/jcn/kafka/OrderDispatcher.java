package br.com.jcn.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDispatcher {
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
        kafkaTemplate.send("order-dispatcher", message);
	}
}
