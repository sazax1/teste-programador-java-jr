package com.sazax.entidade;

public class Produto {
	
	public Integer id;
	public String descricao;
	public static Integer unidade;
	public static Float valor;

	public Produto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		Produto.unidade = unidade;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		Produto.valor = valor;
	}
	
	
	
}
