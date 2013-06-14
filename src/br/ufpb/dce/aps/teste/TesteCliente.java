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

	private FachadaFiado ff ;
	// contantes para endereco e contato	
	private String bairro;
	private String rua;
	private String numero;
	private String telefone;
	private String referencia;
	private String cpf;
	private String nome;

	@Before
	public void setUp(){
		ff= new FachadaFiado();

		bairro = "centro";
		rua = "quintaAvenida";
		numero = "1000";
		telefone= "9999-9999";
		referencia = "perto da farmacia";
		cpf = "098765432-12";
		nome = "Vinicius";
		
		try {
			// cadastrando cliente
			ff.ControleCliente().cadastrarCliente(numero, nome, rua, bairro, telefone, referencia, cpf);
		} catch (ClienteJaCadastradoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeNomeDoCliente(){
		assertEquals(this.nome, ff.ControleCliente().buscarCliente(this.cpf).getNome());
	}
	
	@Test
	public void testeCPFdoCliente(){
		assertEquals(this.cpf, ff.ControleCliente().buscarCliente(this.cpf).getCPF());
	}
	
	@Test
	public void testeTelefoneDoCliente(){
		assertEquals(this.telefone,ff.ControleCliente().buscarCliente(this.cpf).getTelefone());
	}
	
	@Test
	public void testeRuaDoCliente(){
		assertEquals(this.rua, ff.ControleCliente().buscarCliente(this.cpf).getEndereco().getRua());
	}
	
	@Test
	public void testeNumeroDaCadaDoCliente(){
		assertEquals(this.numero,ff.ControleCliente().buscarCliente(this.cpf).getEndereco().getNumero());
	}
	
	
	@Test
	public void testeClienteRemovido(){
		assertEquals(true, ff.ControleCliente().removerCliente(this.cpf));
	}
	
	@Test
	public void testeBairroDoCliente(){
		assertEquals(this.bairro,ff.ControleCliente().buscarCliente(this.cpf).getEndereco().getBairro());
	}
	
	@Test
	public void testaReferenciaDoCliente(){
		assertEquals(this.referencia,ff.ControleCliente().buscarCliente(this.cpf).getEndereco().getReferencia());
	}

}
