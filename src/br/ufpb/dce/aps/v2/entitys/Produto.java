package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public class Produto implements Entity {
	private String	nome;
	private int			codigo;
	private double	valor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
