package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;

public class ControleProduto {

	private List<Produto> estoque = new LinkedList<Produto>();
	private Produto p;
	private int contadorDeProduto = 0;

	public void cadastrarProduto(String nome, int codigo, float preco)
			throws ProdutoJaCadastradoException {
		p = new Produto();
		// se lista vazia
		if (this.estoque.isEmpty()) {
			p.setNome(nome);
			p.setPreco(preco);
			p.setCodigo(codigo);
			this.estoque.add(p);
			this.contadorDeProduto++;

			// se lista não vazia, cheque se os produtos já existente
		} else if (codigo != this.buscarProduto(codigo).getCodigo()) {
			p.setNome(nome);
			p.setPreco(preco);
			p.setCodigo(codigo);
			this.contadorDeProduto++;
			this.estoque.add(p);
			
			// se produto ja existe
		} else {
			throw new ProdutoJaCadastradoException("Produto Exception");
		}
	}

	public boolean removerProduto(int codigo) {
		Produto p = this.buscarProduto(codigo);
		if (p != null) {
			this.estoque.remove(p);
			this.contadorDeProduto--;
			return true;
		}
		return false;
	}

	

	public Produto buscarProduto(int codigo) {
		for (Produto p : estoque)
			if (p.getCodigo() == codigo)
				return p;
		return null;
	}
	
	public int getNumeroDeProdutos(){
		return this.contadorDeProduto;
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		if(!this.estoque.isEmpty())
		return this.estoque;
		return null;
	}

}
