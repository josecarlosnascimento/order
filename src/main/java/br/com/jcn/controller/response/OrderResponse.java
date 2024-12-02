package br.com.jcn.controller.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import br.com.jcn.model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderResponse(@JsonProperty("codigo") Long id,
							@JsonProperty("cliente") String customerName,
							@JsonProperty("total") double total,
							@JsonProperty("status") OrderStatus status,
							@JsonProperty("produtos") List<OrderItensResponse> itens){

}
