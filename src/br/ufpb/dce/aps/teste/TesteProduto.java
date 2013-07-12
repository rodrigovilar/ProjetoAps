package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteProduto {

	// valor abaixo feito para ser setado ao produto no setCodigo
	private int codigoDefault;

	// nome do produto
	private String nomeDoProduto;

	// valor abaixo feito para ser
	private float precoDefault;

	FachadaFiado ff;

	/**
	 * ja cadastro um produto aki no before. Isso simplifica os testes
	 */
	@Before
	public void setUp() {
		this.codigoDefault = 1;
		this.nomeDoProduto = "Nal";
		this.precoDefault = 200;

		ff = new FachadaFiado();
		ff.cadastrarProduto(this.nomeDoProduto, this.codigoDefault,
				this.precoDefault);

	}

	@Test
	public void verSeOProdutoEstaCadastrado() {
		assertEquals(1, ff.buscarProduto(this.codigoDefault).getCodigo());

	}

	@Test
	public void verSeProdutoTemNome() {
		assertEquals(this.nomeDoProduto, ff.buscarProduto(this.codigoDefault)
				.getNome());
	}

	@Test
	public void verificaPrecoDoProduto() {
		assertEquals(this.precoDefault, ff.buscarProduto(this.codigoDefault)
				.getPreco(), 0.1);
	}

	@Test
	public void verificaSeRemoveProduto() {
		assertEquals(true, ff.removerProduto(this.codigoDefault));
	}

	@Test(expected = ProdutoJaCadastradoException.class)
	public void excecaoDeProdutoJaExistente() {
		ff.cadastrarProduto(this.nomeDoProduto, this.codigoDefault,
				this.precoDefault);
		System.out.println(ff.getNumeroDeProdutos());
	}
	
	@Test  // (expected = ValorInvalidoException.class)
	public void excecaoDeNomeComNumeros(){
		ff.cadastrarProduto( "sifu", 21, this.precoDefault);
	}

}
