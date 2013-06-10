package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import br.ufpb.dce.aps.projeto.*;

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
		this.criaProduto();
		assertEquals("Vinicius", p.getNome());
	}

	@Test
	public void verificaPrecoDoProduto() {
		this.criaProduto();
		assertEquals(40, p.getPreco(), 0.1);
	}

	@Test
	public void addProdutoNaLista() {
		cp.cadastrarProduto(p.getNome(), p.getCodigo(), p.getPreco());
		assertEquals(p.getNome(), cp.buscarProduto(p.getCodigo()).getNome());

	}

}
