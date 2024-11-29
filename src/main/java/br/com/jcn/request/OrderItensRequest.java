package br.com.jcn.request;

import lombok.Data;

@Data
public class OrderItensRequest {
	
	private Long productId;
	private Integer amount; 

}
