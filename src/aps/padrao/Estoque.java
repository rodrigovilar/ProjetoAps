package aps.padrao;

public class Estoque {
	private Produto	produto;
	private int quantidade;

	public Estoque(Produto p,int q){
		/*
		 * Cria estoque de um produto 
		 */
		this.setProduto(p);
		this.setQuantidade(q);
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
