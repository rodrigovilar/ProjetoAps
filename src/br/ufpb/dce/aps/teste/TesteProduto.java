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

		p = new Produto();
		p.setCodigo(CODIGO_CADASTRADO);
		p.setNome("Sabao");
		p.setPreco(12);

		ff = new FachadaFiado();

		try {
			ff.cadastrarProduto(p);
		} catch (ProdutoJaCadastradoException pj) {

		}

	}

	@Test
	public void verSeOProdutoEstaCadastrado() {
		assertEquals(p.getCodigo(), ff.buscarProduto(p.getCodigo()).getCodigo());
	}

	@Test
	public void checkQuantidadeDeItens() {
		assertEquals(ff.getNumeroDeProdutos(), 1);

		p = new Produto();
		p.setCodigo("1");
		p.setNome("duza");
		p.setPreco(100);

		ff.cadastrarProduto(p);

		assertEquals(ff.getNumeroDeProdutos(), 2);
		ff.removerProduto("1");
	}

	@Test
	public void checkProdutoNaoCadastrado() {
		assertNull(ff.buscarProduto("321"));
	}

	@Test
	public void checkRemoverProduto() {
		p = new Produto();
		p.setCodigo("1");
		p.setNome("duza");
		p.setPreco(100);

		assertEquals(ff.getNumeroDeProdutos(), 1);
		ff.cadastrarProduto(p);
		assertEquals(ff.getNumeroDeProdutos(), 2);
		ff.removerProduto("1");
		
		assertNull(ff.buscarProduto("1"));
	}

	@Test
	public void removerProdutoInexistente() {
		assertFalse(ff.removerProduto("11"));
	}

	@Test
	public void testEstoque() {
		assertEquals(ff.exibirEstoque().get(0).getCodigo(), p.getCodigo());
	}

	// check atributos
	@Test
	public void verSeProdutoTemNome() {
		assertEquals(p.getNome(), ff.buscarProduto(p.getCodigo()).getNome());
	}

	@Test
	public void verificaPrecoDoProduto() {
		assertEquals(p.getPreco(), ff.buscarProduto(p.getCodigo()).getPreco(),
				0.1);
	}

	@Test
	public void verificaSeRemoveProduto() {
		assertEquals(true, ff.removerProduto(p.getCodigo()));
	}

	@Test(expected = ProdutoJaCadastradoException.class)
	public void excecaoDeProdutoJaExistente() {
		ff.cadastrarProduto(p);

	}

	@Test(expected = ValorInvalidoException.class)
	public void excecaoDeNomeComNumeros() {
		p.setNome("987");
		ff.cadastrarProduto(p);
	}

	@Test(expected = ValorInvalidoException.class)
	public void excecaoDeCodigoComLetras() {
		p.setCodigo("abs");
		ff.cadastrarProduto(p);
	}

}
