package com.api.helpr.domain;

import java.io.Serializable;
import java.time.LocalDate;
import com.api.helpr.domain.enums.Perfil;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Integer id; /* restringir o acesso, restringir acesso ao front*/
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> perfils = new HashSet<>(); /*Set prepara a instancia do perfil*/
	protected LocalDate dataCriacao = LocalDate.now();
	
	/*Construtor*/
	public Pessoa() {
		super();
		addPerfils(Perfil.CLIENTE);
	}
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfils(Perfil.CLIENTE);
	}
	
	/* Get Set*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Perfil> getPerfils() { /* exibir o perfil, get entrega um valor/stram mapeando de acordo com o valor que veio no perfil, vai validar de acordo com a etiqueta*/
		return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	public void addPerfils(Perfil perfils) { /*deixou de ser Set virou add/ passa por validação ao dar o get código, se não existir o perfil, da erro. */
		this.perfils.add(perfils.getCodigo());
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	/*equals*/
	@Override /* notação - toda vez que chamar Pessoa hashCode ele compara */
	public int hashCode() {
		return Objects.hash(cpf, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	
}
