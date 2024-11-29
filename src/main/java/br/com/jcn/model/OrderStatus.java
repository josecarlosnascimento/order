package br.com.jcn.model;

public enum OrderStatus {
	
	PENDENTE(1, "PENDENTE"),
	CALCULADO(2, "CALCULADO");
	
	private int id;
	private String description;
	
	private OrderStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
