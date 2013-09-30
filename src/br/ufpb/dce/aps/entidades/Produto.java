package br.ufpb.dce.aps.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	private String codigo;
	
	private String nome;

	private float preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
	public boolean equals(Object o) {
		Produto p = (Produto) o;
		if ((this.codigo == p.codigo) && (this.nome == p.nome)
				&& (this.preco == p.preco))
			return true;

		return false;
	}
}