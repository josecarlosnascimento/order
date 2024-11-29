package br.com.jcn.controller.response;

import java.math.BigDecimal;

import br.com.jcn.model.OrderStatus;

public record OrderResponse(Long id,
							String customerName,
							BigDecimal total, 
							OrderStatus status)

{

}
