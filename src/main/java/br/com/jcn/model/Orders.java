package br.com.jcn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = -59174880198624507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private Set<OrderItens> orderItens;

	private double total;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status = OrderStatus.CALCULADO;

	private LocalDate orderDate = LocalDate.now();

	private int hashOrder;

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Orders orders = (Orders) o;
		return Objects.equals(customer.getId(), orders.customer.getId())
				&& Objects.equals(orderItens, orders.orderItens) && Objects.equals(orderDate, orders.orderDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer.getId(), orderItens, orderDate);
	}
}
