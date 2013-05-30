package aps.gerente;

import aps.padrao.Produto;

public class GerenteProduto {
	private Produto	produto;
	private int			quantidade;
	
	public boolean addProduto(int c, String nome) {
		produto = new Produto(c, nome);
		return this.quantidade == 0;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void addQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void remove() {
		this.quantidade--;
	}
	
}
