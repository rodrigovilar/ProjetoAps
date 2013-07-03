package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteClienteTest {

	@Test
	public void testeCadastraCliente() {
		FachadaFiado ff = new FachadaFiado();
		// ff.ControleCliente().cadastrarCliente(91, "joao", "antonio diogo",
		// "novo", 333, "praca", "999");
		assertEquals("joao", ff.ControleCliente().buscarCliente("999")
				.getNome());
		assertEquals("antonio diogo", ff.ControleCliente().buscarCliente("999")
				.getEndereco().getRua());
		assertEquals("novo", ff.ControleCliente().buscarCliente("999")
				.getEndereco().getBairro());
		assertEquals(97, ff.ControleCliente().buscarCliente("999")
				.getEndereco().getNumero());
		assertEquals("praca", ff.ControleCliente().buscarCliente("999")
				.getEndereco().getReferencia());
		assertEquals("999", ff.ControleCliente().buscarCliente("999").getCpf());
	}

}
