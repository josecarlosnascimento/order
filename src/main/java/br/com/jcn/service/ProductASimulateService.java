package br.com.jcn.service;


import br.com.jcn.request.OrderItensRequest;
import br.com.jcn.request.OrderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ProductASimulateService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String send() throws JsonProcessingException {
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            OrderRequest orderRequest = new OrderRequest();

            orderRequest.setCustomerId((long) (random.nextInt(30) + 1));

            Set<OrderItensRequest> orderItensSet = new HashSet<>();
            int numItens = random.nextInt(30) + 1;
            for (int j = 0; j < numItens; j++) {
                OrderItensRequest orderItem = new OrderItensRequest();
                orderItem.setProductId((long) (random.nextInt(45) + 1));
                orderItem.setAmount(random.nextInt(200) + 1);
                orderItensSet.add(orderItem);
            }
            orderRequest.setOrderItens(orderItensSet);

            String orderAsMessage = objectMapper.writeValueAsString(orderRequest);
            kafkaTemplate.send("process-order", orderAsMessage);
        }
        return "Pagamento enviado";

    }
}
