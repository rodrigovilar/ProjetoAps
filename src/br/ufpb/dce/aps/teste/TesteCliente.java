package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteCliente {

	private FachadaFiado ff;
	// atributos para endereco e contato

	private Cliente c;
	private Endereco e;

	@Before
	public void setUp() throws ClienteJaCadastradoException,
	CPFInvalidoException, ClienteNaoCadastradoException {
		ff = new FachadaFiado();
		c = new Cliente();
		e = new Endereco("1000", "quinta Avenida", "centro", "longe de tudo");

		this.c.setTelefone("234");
		this.c.setCPF("09876543212");
		this.c.setNome("Vinicius");
		this.c.setEndereco(e);

		// cadastrando cliente
		ff.cadastrarCliente(c);

	}

	// testes com cadastros de clientes

	@Test(expected = ClienteJaCadastradoException.class)
	public void testCadastrarCliente() throws ClienteJaCadastradoException,
	CPFInvalidoException, ClienteNaoCadastradoException {
		assertEquals(1, ff.listarClientes().size());

		Cliente c2 = new Cliente();
		c2.setNome("Cliente Teste");
		c2.setCPF("12345678901");
		ff.cadastrarCliente(c2);

		assertEquals(2, ff.listarClientes().size());

		Cliente c3 = new Cliente();
		c3.setNome("Cliente já cadastrado");
		c3.setCPF("12345678901");
		ff.cadastrarCliente(c3);
		
		assertEquals(3, ff.listarClientes().size());
	

	
	}

	// testes no metodo remove
	@Test
	public void testRemoverCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException, ClienteJaCadastradoException {
		Cliente cliente = new Cliente();
		cliente.setCPF("12345678911");
		ff.cadastrarCliente(cliente);
		assertEquals(2, ff.listarClientes().size());

		ff.removerCliente("12345678911");
		assertEquals(1, ff.listarClientes().size());

	}

	@Test(expected = ClienteNaoCadastradoException.class)
	public void removerClienteNaoCadastrado() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(true, ff.removerCliente("12312312312"));
	}

	// testes em buscas
	@Test
	public void testBuscarCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c, ff.buscarCliente("09876543212"));

		assertNull(ff.buscarCliente("12345678901"));
	}

	@Test
	public void buscarClienteInexistente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertNull(ff.buscarCliente("12312312312"));
	}

	// teste no listar
	@Test
	public void testListarClientes() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(1, ff.listarClientes().size());

		ff.removerCliente("09876543212");

		assertEquals(0, ff.listarClientes().size());
	}

	// testes nos atributos
	@Test
	public void testeNomeDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getNome(), ff.buscarCliente(c.getCPF()).getNome());
	}

	@Test
	public void testeCPFdoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getCPF(), ff.buscarCliente(c.getCPF()).getCPF());
	}

	@Test
	public void testeTelefoneDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getTelefone(), ff.buscarCliente(c.getCPF())
				.getTelefone());
	}

	@Test
	public void testeRuaDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getEndereco().getRua(), ff.buscarCliente(c.getCPF())
				.getEndereco().getRua());
	}

	@Test
	public void testeNumeroDaCadaDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getEndereco().getNumero(), ff.buscarCliente(c.getCPF())
				.getEndereco().getNumero());
	}

	@Test
	public void testeClienteRemovido() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(true, ff.removerCliente(c.getCPF()));
	}

	@Test
	public void testeBairroDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getEndereco().getBairro(), ff.buscarCliente(c.getCPF())
				.getEndereco().getBairro());
	}

	@Test
	public void testaReferenciaDoCliente() throws CPFInvalidoException,
	ClienteNaoCadastradoException {
		assertEquals(c.getEndereco().getReferencia(),
				ff.buscarCliente(c.getCPF()).getEndereco().getReferencia());
	}

	@Test(expected = ClienteJaCadastradoException.class)
	public void excecaoDeClienteJaExistente()
			throws ClienteJaCadastradoException, CPFInvalidoException,
			ClienteNaoCadastradoException {
		ff.cadastrarCliente(c);

	}

}
