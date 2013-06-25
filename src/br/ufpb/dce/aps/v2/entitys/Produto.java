package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public class Produto implements Entity {
	
	private int			codigo;
	private String	nome;
	private double	valor;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
