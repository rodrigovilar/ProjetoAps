package br.ufpb.dce.aps.entidades;

public class Produto {

	private String nome;

	private int codigo;

	private float preco;

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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String toString() {
		return this.nome + " " + this.codigo + "\n";
	}
	
	@Override
	public boolean equals(Object o){
		Produto p = (Produto) o;
		if((this.codigo == p.codigo) && (this.nome == p.nome) && (this.preco == p.preco))
			return true;
		
		return false;
	}
}