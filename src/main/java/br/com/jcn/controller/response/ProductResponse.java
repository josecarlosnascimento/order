package br.com.jcn.controller.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(@JsonProperty("codigo") Long id,
								@JsonProperty("nome") String name,
								@JsonProperty("valor unitario") BigDecimal unitPrice) {
	
}