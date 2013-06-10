package br.ufpb.dce.aps.projeto;
import java.util.LinkedList;
import java.util.List;

public class ControleProduto {

	private List <Produto> estoque = new LinkedList<Produto>();
	private Produto p;

	public void cadastrarProduto(String nome, int cod, float preco) {
		p = new Produto();
		p.setNome(nome);
		p.setPreco(preco);
		p.setCodigo(cod);
		this.estoque.add(p);
	}

	public boolean removerProduto(int cod) {
		Produto p = this.buscarProduto(cod) ;
		if(p != null){
			this.estoque.remove(p);
			return true;
		} return false;
	}

	public void adicionarProduto(int cod, int quant) {
		//  ????????????????????
	}

	public Produto buscarProduto(int cod) {
		for(Produto p : estoque)
			if(p.getCodigo()==cod)
				return p;
		return null;
	}

	public List exibirEstoqueDeProdutos() {
		return this.estoque;
	}

}
