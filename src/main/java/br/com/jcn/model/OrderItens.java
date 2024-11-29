package br.com.jcn.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class OrderItens implements Serializable {
	
	private static final long serialVersionUID = -3337015889315881126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
	private Product product;
    
	private Integer amount;
	private BigDecimal total;

	@ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;
}
