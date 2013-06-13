package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;


public class TesteProduto {
	
	//valor abaixo feito para ser setado ao produto no setCodigo
	public static final int codigoDefault = 1;
	
	//nome do produto
	public static final String nomeDoProduto = "Sifu";
	
	// valor abaixo feito para ser 
	public static final int precoDefault = 40;
	
	FachadaFiado ff ;

	/**
	 * ja cadastro um produto aki no before. Isso simplifica os testes
	 */
	@Before
	public void setUp() {
		ff = new FachadaFiado();
		try {
			ff.controleProdutos().cadastrarProduto(this.nomeDoProduto, this.codigoDefault, this.precoDefault);
		} catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void verSeOProdutoEstaCadastrado() {
		assertEquals(1, ff.controleProdutos().buscarProduto(this.codigoDefault).getCodigo());
			
	}

	@Test
	public void verSeProdutoTemNome() {
		assertEquals(this.nomeDoProduto, ff.controleProdutos().buscarProduto(this.codigoDefault).getNome());
	}

	
	@Test
	public void verificaPrecoDoProduto() {
		assertEquals(this.precoDefault, ff.controleProdutos().buscarProduto(this.codigoDefault).getPreco(),0.1);
	}
	@Test
	public void verificaSeRemoveProduto(){
		assertEquals(true,ff.controleProdutos().removerProduto(this.codigoDefault));
	}


}
