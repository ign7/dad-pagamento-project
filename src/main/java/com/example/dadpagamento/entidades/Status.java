package com.example.dadpagamento.entidades;

public enum Status {

	
	PENDENTE("PENDENTE"),
	PAGO("PAGO"),
	CANCELADO("CANCELAOD");
	
	private String role;
	
	Status(String role){
		this.role=role;
	}
	
	public String GetRole(){
		return role;
	}
}
