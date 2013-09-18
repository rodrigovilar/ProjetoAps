package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteProduto {

	public static final String CODIGO_CADASTRADO = "12"; 
	FachadaFiado ff;
	Produto p;

	/**
	 * ja cadastro um produto aki no before. Isso simplifica os testes
	 */
	@Before
	public void setUp() {
		
		p= new Produto();
		p.setCodigo(CODIGO_CADASTRADO);
		p.setNome("Nal");
		p.setPreco(200);

		ff = new FachadaFiado();
		ff.cadastrarProduto(p);

	}

	@Test
	public void verSeOProdutoEstaCadastrado() {
		assertEquals(p, ff.buscarProduto(p.getCodigo()));

	}
	@Test
	public void checkQuantidadeDeItens(){
		assertEquals(ff.getNumeroDeProdutos(), 1);
		
		p= new Produto();
		p.setCodigo("1");
		p.setNome("duza");
		p.setPreco(100);
		
		ff.cadastrarProduto(p);
		
		assertEquals(ff.getNumeroDeProdutos(), 2);
	}
	
	@Test
	public void checkProdutoNaoCadastrado(){
		assertNull(ff.buscarProduto("321"));
	}
	
	@Test
	public void checkRemoverProduto(){
		ff.removerProduto(CODIGO_CADASTRADO);
		assertNull(ff.buscarProduto(CODIGO_CADASTRADO));
	}
	
	@Test
	public void removerProdutoInexistente(){
		assertFalse(ff.removerProduto("1"));
	}
	
	
	@Test
	public void verNumeroDeprodutos(){
		assertEquals(ff.exibirEstoqueDeProdutos().size(), 1);
		
		p=new Produto();
		p.setCodigo("13");
		p.setNome("duza");
		p.setPreco(140);
		ff.cadastrarProduto(p);
		
		assertEquals(ff.exibirEstoqueDeProdutos().size(), 2);
	}
	
	@Test
	public void testEstoque(){
		assertEquals(ff.exibirEstoque().get(0), p);
	}
	

	// check atributos
	@Test
	public void verSeProdutoTemNome() {
		assertEquals(p.getNome(), ff.buscarProduto(p.getCodigo())
				.getNome());
	}

	@Test
	public void verificaPrecoDoProduto() {
		assertEquals(p.getPreco(), ff.buscarProduto(p.getCodigo())
				.getPreco(), 0.1);
	}

	@Test
	public void verificaSeRemoveProduto() {
		assertEquals(true, ff.removerProduto(p.getCodigo()));
	}

	@Test(expected = ProdutoJaCadastradoException.class)
	public void excecaoDeProdutoJaExistente() {
		ff.cadastrarProduto(p);

	}
	
	@Test   (expected = ValorInvalidoException.class)
	public void excecaoDeNomeComNumeros(){
		p.setNome("987");
		ff.cadastrarProduto(p);
	}
	@Test (expected = ValorInvalidoException.class)
	public void excecaoDeCodigoComLetras(){
		p.setCodigo("abs");
		ff.cadastrarProduto(p);
	}

}
