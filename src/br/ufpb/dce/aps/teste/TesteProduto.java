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
	
	// valor abaixo feito para ser 
	public static final int precoDefault = 40;
	
	FachadaFiado ff ;

	@Before
	public void setUp() {
		ff = new FachadaFiado();
		try {
			ff.controleProdutos().cadastrarProduto("Vinicius", this.codigoDefault, this.precoDefault);
		} catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void criaProduto() {
		assertEquals(1, ff.controleProdutos().buscarProduto(this.codigoDefault).getCodigo());
			
	}

	@Test
	public void verSeProdutoTemNome() {
		assertEquals("Vinicius", ff.controleProdutos().buscarProduto(this.codigoDefault).getNome());
	}

	
	@Test
	public void verificaPrecoDoProduto() {
		assertEquals(40, ff.controleProdutos().buscarProduto(this.codigoDefault).getPreco(),0.1);
	}


}
