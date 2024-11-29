package br.com.jcn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -59174880198624507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer custumer;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderItens> orderItens;

	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

}
