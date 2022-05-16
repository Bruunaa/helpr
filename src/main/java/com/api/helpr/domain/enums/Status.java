package com.api.helpr.domain.enums;

public enum Status {
ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {  /* Null, se existe um valor  */
		if(cod == null) {
			return null;
		}
		for(Status x : Status.values()) { /* Verifica qual o valor */
			if(cod.equals(x.getCodigo())) { 
				return x;
			}
		}
		throw new IllegalArgumentException("Status Inválido"); /* verifica se o valor é uma exceção */
	}
	

}
