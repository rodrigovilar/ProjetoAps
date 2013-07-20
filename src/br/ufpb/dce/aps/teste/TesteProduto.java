package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteProduto {

	
	FachadaFiado ff;
	Produto p;

	/**
	 * ja cadastro um produto aki no before. Isso simplifica os testes
	 */
	@Before
	public void setUp() {
		
		p= new Produto();
		p.setCodigo("12");
		p.setNome("Nal");
		p.setPreco(200);

		ff = new FachadaFiado();
		ff.cadastrarProduto(p);

	}

	@Test
	public void verSeOProdutoEstaCadastrado() {
		assertEquals(p.getCodigo(), ff.buscarProduto(p.getCodigo()).getCodigo());

	}

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
		System.out.println(ff.getNumeroDeProdutos());
	}
	
	@Test   (expected = ValorInvalidoException.class)
	public void excecaoDeNomeComNumeros(){
		p.setNome("987");
		ff.cadastrarProduto(p);
	}

}
