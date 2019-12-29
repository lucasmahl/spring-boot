package com.educandoweb.curso.entities.enums;

public enum OrderStatus {
	WATING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//construtor para o code PRIVATE
	private OrderStatus (int code) {
		this.code = code;
	}
	
	//para o code ficar acessivel ao exterior
	public int getCode() {
		return code;
	}
	
	//metodo estatico para converter o valor numerico para o tipo enumerado
	//static pq vai funcionar sem precisar instancia
	public static OrderStatus valueOf(int code) {
		for (OrderStatus o : OrderStatus.values()) {
			if (o.getCode() == code) {
				return o;
			}
		}
		throw new IllegalArgumentException("Código de OrderStatus inválido.");
	}
	
}
