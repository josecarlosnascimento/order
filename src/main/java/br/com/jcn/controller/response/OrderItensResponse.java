package br.com.jcn.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record OrderItensResponse(@JsonProperty("nome") String productName,
                                 @JsonProperty("preço unitario") BigDecimal unitPrice,
                                 @JsonProperty("quantidade") Integer amount,
                                 @JsonProperty("total") BigDecimal total) {
}
