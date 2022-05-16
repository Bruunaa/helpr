package com.api.helpr.domain.enums;

public enum Prioridade {
BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA	");
	
	private Integer codigo;
	private String descricao;
	
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Prioridade toEnum(Integer cod) {  /* Null, se existe um valor  */
		if(cod == null) {
			return null;
		}
		for(Prioridade x : Prioridade.values()) { /* Verifica qual o valor */
			if(cod.equals(x.getCodigo())) { 
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade Inválida"); /* verifica se o valor é uma exceção */
	}
}
