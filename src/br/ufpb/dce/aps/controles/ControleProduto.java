package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;

public class ControleProduto {

	private List<Produto> estoque = new LinkedList<Produto>();
	private Produto p;

	public void cadastrarProduto(String nome, int cod, float preco)
			throws ProdutoJaCadastradoException {
		p = new Produto();
		// se lista vazia
		if (null == this.buscarProduto(cod)) {
			p.setNome(nome);
			p.setPreco(preco);
			p.setCodigo(cod);
			this.estoque.add(p);
			// se lista não vazia, cheque se os produtos já existente
		} else if (cod != this.buscarProduto(cod).getCodigo()) {
			p.setNome(nome);
			p.setPreco(preco);
			p.setCodigo(cod);
			this.estoque.add(p);
			// se produto ja existe
		} else {
			throw new ProdutoJaCadastradoException();
		}
	}

	public boolean removerProduto(int cod) {
		Produto p = this.buscarProduto(cod);
		if (p != null) {
			this.estoque.remove(p);
			return true;
		}
		return false;
	}

	

	public Produto buscarProduto(int cod) {
		for (Produto p : estoque)
			if (p.getCodigo() == cod)
				return p;
		return null;
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		return this.estoque;
	}

}
