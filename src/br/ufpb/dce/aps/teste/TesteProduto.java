package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import br.ufpb.dce.aps.projeto.*;

public class TesteProduto {
	Produto p ;
	ControleProduto cp;


	@Before
	public void setUp(){
		p= new Produto();
		cp = new ControleProduto();
	}
	
	@Test
	public void addProduto(){
		p.setCodigo(1);
		p.setNome("Vinicius");
		p.setPreco(40);
		assertEquals(1, p.getCodigo());
		assertEquals("Vinicius", p.getNome());
		assertTrue(40==p.getPreco());
		assertEquals(40,p.getPreco(), 0.1);
	}
	
}
