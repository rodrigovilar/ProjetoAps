package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.ValorInvalidoException;

public class ControleProduto {
	private List<Produto> estoque = new LinkedList<Produto>();

	public void cadastrarProduto(Produto p)
			throws ProdutoJaCadastradoException, ValorInvalidoException {
		boolean teste = this.ehValido(p.getNome(), p.getCodigo());

		if (teste)
			if (this.buscarProduto(p.getCodigo()) == null)
				this.estoque.add(p);
			else
				throw new ProdutoJaCadastradoException("Produto ja existe");
		else
			throw new ValorInvalidoException("valores invalidos");
	}

	public boolean removerProduto(String codigo) {
		Produto p = this.buscarProduto(codigo);
		return this.estoque.remove(p);
	}

	public Produto buscarProduto(String codigo) throws ValorInvalidoException {
		if (!this.ehValido(codigo))
			throw new ValorInvalidoException("valor invalido");
		else {
			for (Produto p : estoque)
				if (p.getCodigo() == codigo)
					return p;
			return null;
		}
	}

	public int getNumeroDeProdutos() {
		return this.estoque.size();
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		if (!this.estoque.isEmpty())
			return this.estoque;
		return null;
	}

	private boolean ehValido(String nome, String codigo) {
		// testador de entrada de parâmetros
		if ((nome.matches("[A-Za-z]{" + nome.length() + "}")) && (codigo.matches("[0-9]{" + codigo.length() + "}")))
			return true;
		return false;
	}

	private boolean ehValido(String codigo) {
		// testador de entrada de parâmetros para busca e remoção
		if ((codigo.matches("[0-9]{" + codigo.length() + "}")))
			return true;
		return false;
	}
}