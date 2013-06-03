package br.ufpb.dce.aps.v1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClasseDeTeste {
	GerenteDeProdutos	g;
	
	@Before
	public void setUp() {
		g = new GerenteDeProdutos();
	}
	
	@Test
	public void adicionaProduto() {
		assertTrue(g.adicionarProduto(0, 0, 0, "Laptop"));
	}
	
	@Test
	public void getProduto() {
		g.adicionarProduto(0, 0, 0, "Laptop");
		Produto p = g.getProduto(0);
		assertEquals(p, g.getProduto(0));
	}
	
	@Test
	public void setProduto() {
		g.adicionarProduto(0, 0, 0, "Laptop");
		Produto p = new Produto(0);
		p.setNome("Notebook");
		assertEquals(g.getProduto(0), p);
	}
	
	@Test
	public void setProduto_setCodigo() {
		g.adicionarProduto(0, 0, 0, "Laptop");
		Produto p = new Produto(0);
		assertFalse(p.equals(g.getProduto(1)));
	}
}
