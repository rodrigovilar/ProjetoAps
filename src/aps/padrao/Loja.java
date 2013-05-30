package aps.padrao;


public class Loja {
	private Estoque	estoque;
	
	public Estoque getEstoque() {
		return estoque;
	}
	
	public Loja() {
		estoque = new Estoque();
	}
}