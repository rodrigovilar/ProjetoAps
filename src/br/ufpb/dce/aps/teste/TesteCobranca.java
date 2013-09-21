package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Item;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.exception.VendaException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteCobranca {

	private FachadaFiado ff;
	private Cobranca cobranca;
	private Venda venda;
	private Item item;
	private Produto produto;
	private Cliente cliente;

	@Before
	public void setUp() {
		// creator
		this.ff = new FachadaFiado();
		this.cobranca = new Cobranca();
		this.venda = new Venda();
		this.item = new Item();
		this.produto = new Produto();
		this.cliente = new Cliente();

		Endereco e = new Endereco("13", "mangueira", "sifu", null);

		// produto
		this.produto.setCodigo("12343");
		this.produto.setNome("sabão");
		this.produto.setPreco(12);

		// item
		this.item.setProduto(this.produto);
		this.item.setQuantidade(5);

		// cliente
		this.cliente.setCPF("12345678912");
		this.cliente.setEndereco(e);
		this.cliente.setNome("Vinicius");
		this.cliente.setTelefone("09093392");

		// venda
		this.venda.setIdVenda("123432");
		this.venda.setCliente(this.cliente);
		this.venda.setCliente(this.cliente);
		this.venda.setValor(150);
		this.venda.setDataPagamento(new Date());
		this.venda.setDataVenda(new Date());

		// cobranca
		this.cobranca.setDataPagamento(null);
		this.cobranca.setPagamentoEfetuado(false);
		this.cobranca.setVenda(this.venda);

		// cadastrar cobrança

		this.ff.addCobranca(this.cobranca, this.venda.getIdVenda());

	}

	//
	@Test
	public void checkCobranca() {
		assertEquals(this.cobranca,
				this.ff.exibirCobranca(this.venda.getIdVenda()));

	}

	@Test
	public void verificarValorDaVenda() {
		Cobranca cobranca = ff.exibirCobranca(this.venda.getIdVenda());
		assertEquals(this.venda.getValor(), cobranca.getVenda().getValor(), 1);
	}

	@Test
	public void checkDebitosDoCliente() {
		List<Cobranca> lista = this.ff.listarDebitosDoCliente(this.cliente
				.getCPF());
		assertEquals(this.cobranca, lista.get(0));
	}

	@Test(expected = ValorInvalidoException.class)
	public void checkDebitosDoClienteExcecao() {
		// metodo listar aceita apenas números

		// TODO
		List<Cobranca> lista = this.ff.listarDebitosDoCliente(this.cliente
				.getNome()); // nome?! Apenas numeros
		assertEquals(1, lista.size());

	}

	@Test(expected = VendaException.class)
	// lançar exceção
	public void repetirVenda() {
		this.ff.addCobranca(this.cobranca, this.venda.getIdVenda());
	}
	
	@Test
	public void pagar(){			
			ff.pagarCobranca(this.venda.getIdVenda());	
			assertNull(ff.buscarVenda(this.venda.getIdVenda()));
	}


}
