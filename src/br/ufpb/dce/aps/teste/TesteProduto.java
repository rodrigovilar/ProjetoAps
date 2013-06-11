package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;


public class TesteProduto {
	Produto p;
	ControleProduto cp;

	@Before
	public void setUp() {
		p = new Produto();
		cp = new ControleProduto();
	}

	@Test
	public void criaProduto() {
		p.setCodigo(1);
		p.setNome("Vinicius");
		p.setPreco(40);
		assertEquals(1, p.getCodigo());
	}

	@Test
	public void verSeProdutoTemNome() {
		p.setCodigo(1);
		p.setNome("Vinicius");
		p.setPreco(40);
		assertEquals("Vinicius", p.getNome());
	}

	@Test
	public void verificaPrecoDoProduto() {
		p.setCodigo(1);
		p.setNome("Vinicius");
		p.setPreco(40);
		assertEquals(40, p.getPreco(), 0.1);
	}

	@Test
	public void addProdutoNaLista() {
		p.setCodigo(1);
		p.setNome("Vinicius");
		p.setPreco(40);
		try {
			cp.cadastrarProduto(p.getNome(), p.getCodigo(), p.getPreco());
		} catch (ProdutoJaCadastradoException e) {
			e.printStackTrace();
		}
		//assertEquals(p.getNome(), cp.buscarProduto(p.getCodigo()).getNome());
	}

	public void exibirEstoqueDeProdutos() {
		System.out.println(cp.exibirEstoqueDeProdutos());
	}
}
