package aps;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClasseDeTeste {
	Loja	teste;
	
	@Before
	public void setUp() {
		teste = new Loja();
	}
	
	@Test
	public void criandoLoja() {
		assertNotNull(teste);
	}
	
	@Test
	public void verificaSeALojaTemEstoque() {
		assertNotNull(teste.getEstoque());
	}
	
	@Test
	public void estoqueTemProdutos() {
		assertTrue(teste.getEstoque().hasProdutos());
	}
}
