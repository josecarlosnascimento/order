package br.com.jcn.controller.response;

import java.math.BigDecimal;

public record OrderItens(String productName,
							BigDecimal unitPrice,
							Integer amount,
							BigDecimal total) {
}
