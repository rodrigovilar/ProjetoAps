package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.matchers.Each;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteCliente {

	private FachadaFiado ff;
	// atributos para endereco e contato
	
	private Cliente c;
	private Endereco e;
	
	@Before
	public void setUp() throws ClienteJaCadastradoException {
		ff = new FachadaFiado();
		c = new Cliente();
		e= new Endereco("1000" , "quinta Avenida", "centro", "longe de tudo");
	
		this.c.setTelefone("234");
		this.c.setCPF("098765432-12") ;
		this.c.setNome("Vinicius");
		this.c.setEndereco(e);

		// cadastrando cliente
		ff.cadastrarCliente(c);

	}

	@Test
	public void testeNomeDoCliente() {
		assertEquals(c.getNome(), ff.buscarCliente(c.getCPF()).getNome());
	}

	@Test
	public void testeCPFdoCliente() {
		assertEquals(c.getCPF(), ff.buscarCliente(c.getCPF()).getCPF());
	}

	@Test
	public void testeTelefoneDoCliente() {
		assertEquals(c.getTelefone(), ff.buscarCliente(c.getCPF()).getTelefone());
	}

	@Test
	public void testeRuaDoCliente() {
		assertEquals(c.getEndereco().getRua(), ff.buscarCliente(c.getCPF()).getEndereco()
				.getRua());
	}

	@Test
	public void testeNumeroDaCadaDoCliente() {
		assertEquals(c.getEndereco().getNumero(), ff.buscarCliente(c.getCPF()).getEndereco()
				.getNumero());
	}

	@Test
	public void testeClienteRemovido() {
		assertEquals(true, ff.removerCliente(c.getCPF()));
	}

	@Test
	public void testeBairroDoCliente() {
		assertEquals(c.getEndereco().getBairro(), ff.buscarCliente(c.getCPF()).getEndereco()
				.getBairro());
	}

	@Test
	public void testaReferenciaDoCliente() {
		assertEquals(c.getEndereco().getReferencia(), ff.buscarCliente(c.getCPF()).getEndereco()
				.getReferencia());
	}

	@Test(expected = ClienteJaCadastradoException.class)
	public void excecaoDeProdutoJaExistente()
			throws ClienteJaCadastradoException {
		ff.cadastrarCliente(c);

	}
	
	
}
