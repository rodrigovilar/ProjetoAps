package br.ufpb.dce.aps.controles;

import java.util.List;

import br.ufpb.dce.aps.dao.ProdutoDao;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.infra.JPAUtil;

public class ControleProduto {
	private ProdutoDao dao;

	public ControleProduto() {
		dao = new ProdutoDao(JPAUtil.getInstance().getEntityManager(),
				Produto.class);
	}

	public void cadastrarProduto(Produto p)
			throws ProdutoJaCadastradoException, ValorInvalidoException {
		boolean teste = this.ehValido(p.getNome(), p.getCodigo());

		if (teste) {
			Produto prod = this.dao.procurar(p.getCodigo());
			if (prod == null)
				this.dao.adicionar(p);
			else
				throw new ProdutoJaCadastradoException("Produto ja existe");
		} else
			throw new ValorInvalidoException("valores invalidos");
	}

	public boolean removerProduto(String codigo) {
		Produto p = null;
		try {
			p = this.buscarProduto(codigo);
			System.out.println("/////////////////");
			System.out.println(p);
			System.out.println("/////////////////");
			if (p != null) {
				this.dao.remover(p);
				return true;
			}
			return false;
		} catch (ValorInvalidoException vi) {
			return false;
		}
	}

	public Produto buscarProduto(String codigo) throws ValorInvalidoException {
		if (!this.ehValido(codigo))
			throw new ValorInvalidoException("valor invalido");

		return this.dao.procurar(codigo);
	}

	public int getNumeroDeProdutos() {
		return this.dao.listarTodos().size();
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		return this.dao.listarTodos();
	}

	private boolean ehValido(String nome, String codigo) {
		// testador de entrada de par�metros
		if ((nome.matches("[A-Za-z]{" + nome.trim().length() + "}"))
				&& (codigo.matches("[0-9]{" + codigo.trim().length() + "}")))
			return true;
		return false;
	}

	private boolean ehValido(String codigo) {
		// testador de entrada de par�metros para busca e remo��o
		if ((codigo.matches("[0-9]{" + codigo.length() + "}")))
			return true;
		return false;
	}
}