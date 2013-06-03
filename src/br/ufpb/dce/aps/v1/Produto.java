package br.ufpb.dce.aps.v1;

public class Produto {
	private int			codigo;
	private int			quantidade;
	private int			tipo;
	private String	nome;
	
	public Produto(int c, int q, int t, String nome) {
		this.codigo = c;
		this.quantidade = q;
		this.tipo = t;
		this.nome = nome;
	}
	
	public Produto(int c) {
		this.codigo = c;
	}
	
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Produto) {
			return (((Produto) o).getCodigo() == this.getCodigo());
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return getCodigo() + " " + getNome();
	}
}
