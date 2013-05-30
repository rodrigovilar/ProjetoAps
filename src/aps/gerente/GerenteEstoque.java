package aps.gerente;

import aps.padrao.Estoque;
import aps.padrao.Produto;

public class GerenteEstoque {
	private Estoque estoque;
	
	public GerenteEstoque(Produto p) {
		estoque = new Estoque(p, 0);
	}
	
	public boolean hasEstoque(){
		return estoque.getQuantidade() > 0;
	}
}
