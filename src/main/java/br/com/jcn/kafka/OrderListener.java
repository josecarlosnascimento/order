package br.com.jcn.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

	@KafkaListener(topics = "process-order")
	public void process(String message) {
		
	}
}
