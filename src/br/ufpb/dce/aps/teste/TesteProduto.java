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
	private int codigoDefault ;
	
	//nome do produto
	private String nomeDoProduto ;
	
	// valor abaixo feito para ser 
	private int precoDefault ;
	
	FachadaFiado ff ;

	/**
	 * ja cadastro um produto aki no before. Isso simplifica os testes
	 */
	@Before
	public void setUp() {
		this.codigoDefault = 1;
		this.nomeDoProduto = "Nal";
		this.precoDefault = 200;
		
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
