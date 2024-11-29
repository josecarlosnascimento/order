package br.com.jcn.request;

import java.util.Set;

import lombok.Data;

@Data
public class OrderRequest {
	
	private Long customerId;
	private Set<OrderItensRequest> orderItens;

}
