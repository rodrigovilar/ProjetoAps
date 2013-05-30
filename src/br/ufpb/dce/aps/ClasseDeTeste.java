package br.ufpb.dce.aps;

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
	public void getProduto(){
		Produto p = g.getProduto(0);
		assertEquals(p, g.getProduto(0));
	}
	
	@Test
	public void setProduto(){
		Produto p = g.getProduto(0);
		Produto m = g.getProduto(0);
		p.setNome("Notebook");
		assertEquals(m, p);
	}
}
