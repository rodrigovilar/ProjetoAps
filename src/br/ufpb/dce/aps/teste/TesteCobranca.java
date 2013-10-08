package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Item;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
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
	public void setUp() throws CPFInvalidoException,
			ClienteJaCadastradoException, ClienteNaoCadastradoException {
		// creator
		this.ff = new FachadaFiado();
		this.cobranca = new Cobranca();
		this.venda = new Venda();
		this.item = new Item();
		this.produto = new Produto();
		this.cliente = new Cliente();

		Endereco e = new Endereco("12", "Rua", "Bairro", "referencia");

		// produto
		this.produto.setCodigo("12");
		this.produto.setNome("Sabao");
		this.produto.setPreco(12);

		ff.cadastrarProduto(produto);

		// item
		this.item.setProduto(this.produto);
		this.item.setQuantidade(5);

		// cliente
		
		this.cliente.setCPF("12345678901");
		this.cliente.setEndereco(e);
		this.cliente.setNome("Vinicius");
		this.cliente.setTelefone("098909879");

		ff.cadastrarCliente(cliente);

		// venda
		this.venda.setIdVenda("1");
		this.venda.setCliente(this.cliente);
		this.venda.setValor(400);
		this.venda.setDataPagamento(new Date());
		this.venda.setDataVenda(new Date());
		this.venda.getItems().add(this.item);
		
		ff.vender(venda);

		// cobranca
		this.cobranca.setId("1");
		this.cobranca.setDataPagamento(null);
		this.cobranca.setPagamentoEfetuado(false);
		this.cobranca.setVenda(this.venda);

		// cadastrar cobran�a

		this.ff.addCobranca(this.cobranca, this.venda.getIdVenda());
	}
	
	@After
	public void Desfazer() throws CPFInvalidoException, ClienteNaoCadastradoException{
		ff.pagarCobranca(cobranca.getId());
		ff.removerVenda(venda.getIdVenda());
		ff.removerCliente(cliente.getCPF());
		ff.removerProduto(produto.getCodigo());
	}

	//
	@Test
	public void checkCobranca() {
		assertEquals(this.cobranca.getId(),
				this.ff.exibirCobranca(this.cobranca.getId()).getId());

	}

	@Test
	public void verificarValorDaVenda() {
		Cobranca cobranca = ff.exibirCobranca(this.cobranca.getId());
		assertEquals(this.venda.getValor(), cobranca.getVenda().getValor(), 1);
	}

	@Test
	public void checkDebitosDoCliente() {
		List<Cobranca> lista = this.ff.listarDebitosDoCliente(this.cliente
				.getCPF());
		assertEquals(this.cobranca.getId(), lista.get(0).getId());
	}

	@Test(expected = ValorInvalidoException.class)
	public void checkDebitosDoClienteExcecao() {
		// metodo listar aceita apenas n�meros

		List<Cobranca> lista = this.ff.listarDebitosDoCliente(this.cliente
				.getNome()); // nome?! Apenas numeros
		assertEquals(1, lista.size());
	}

	@Test(expected = VendaException.class)
	// lan�ar exce��o
	public void repetirVenda() {
		this.ff.addCobranca(this.cobranca, this.venda.getIdVenda());
	}

	@Test
	public void pagar() {
		ff.pagarCobranca("1");
		assertTrue(ff.exibirCobranca("1").isPagamentoEfetuado());
	}

}
