package br.ufpb.dce.aps.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteCliente {

	public FachadaFiado ff ;
	// contantes para endereco e contato
	public static final String BAIRRO = "centro";
	public static final String RUA = "quintaAvenida";
	public static final String NUMERO = "1000";
	public static final String TELEFONE= "9999-9999";
	public static final String REFERENCIA = "perto da farmacia";
	public static final String CPF = "098765432-12";
	public static final String NOME = "Vinicius";

	@Before
	public void setUp(){
		ff= new FachadaFiado();

		try {
			// cadastrando cliente
			ff.ControleCliente().cadastrarCliente(this.NUMERO, this.NOME, this.RUA,this.BAIRRO, this.TELEFONE, this.REFERENCIA, this.CPF);
		} catch (ClienteJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testeNomeDoCliente(){
		assertEquals(this.NOME, ff.ControleCliente().buscarCliente(this.CPF).getNome());
	}
	
	@Test
	public void testeCPFdoCliente(){
		assertEquals(this.CPF, ff.ControleCliente().buscarCliente(this.CPF).getCPF());
	}
	
	
	@Test
	public void testeClienteRemovido(){
		assertEquals(true, ff.ControleCliente().removerCliente(this.CPF));
	}
	

}
