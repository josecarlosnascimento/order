package br.com.jcn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class OrderItens implements Serializable {
	
	private static final long serialVersionUID = -3337015889315881126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "produto_id")
	private Product product;
    
	private Integer amount;
	private BigDecimal total;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "order_id")
	private Orders orders;

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		OrderItens that = (OrderItens) o;
		return Objects.equals(product.getId(), that.product.getId()) && Objects.equals(amount, that.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product.getId(), amount);
	}
}
