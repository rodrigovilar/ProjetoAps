package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Item;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.VendaException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteVenda {

	private FachadaFiado ff;
	private Venda venda;
	private Item item;
	private Produto produto;
	private Endereco endereco;
	private Cliente cliente;

	public static final String CODIGO_PRODUTO = "12";
	public static final String CODIGO_VENDA = "1";
	public static final String CPF = "12345678901";

	@Before
	public void setUp() throws CPFInvalidoException,
			ClienteNaoCadastradoException {
		this.ff = new FachadaFiado();

		endereco = new Endereco("12", "Rua", "Bairro", "referencia");

		this.cliente = new Cliente();
		this.cliente.setCPF(CPF);
		this.cliente.setNome("Vinicius");
		this.cliente.setTelefone("098909879");
		this.cliente.setEndereco(this.endereco);

		this.produto = new Produto();
		this.produto.setCodigo(this.CODIGO_PRODUTO);
		this.produto.setNome("Sabao");
		this.produto.setPreco(12);

		this.venda = new Venda();

		this.item = new Item();
		this.item.setProduto(this.produto);
		this.item.setQuantidade(20);

		this.venda.setIdVenda(this.CODIGO_VENDA);
		this.venda.setValor(400);
		this.venda.getItems().add(item);
		this.venda.setCliente(this.cliente);
		this.venda.setDataVenda(new Date());
		this.venda.setDataPagamento(new Date());

		try {
			ff.cadastrarCliente(cliente);
		} catch (ClienteJaCadastradoException cj) { }
		
		try{
			ff.cadastrarProduto(produto);
		}catch(ProdutoJaCadastradoException pj) { }
		
		try {
			ff.vender(this.venda);
		}catch (VendaException ve) { }
	}

	@Test
	public void checkVendaRealizada() {
		assertEquals(this.venda.getIdVenda()
				, ff.buscarVenda(venda.getIdVenda()).getIdVenda());
	}

	@Test
	public void removerVenda() {
		ff.removerVenda(this.CODIGO_VENDA);
		assertNull(ff.buscarVenda(this.CODIGO_VENDA));
	}

	@Test /* o before cria um novo objeto com mesma caracterisca. 
	Logo ele não ta comparando os mesmos objetos */
	public void listarVendas() {
		System.out.println(ff.listarVendasRalizadas().size());
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA), ff
				.listarVendasRalizadas().get(0));
	}

	@Test(expected = VendaException.class)
	public void excecaoDeVenda() {
		// nada de fazer a mesma venda duas vezes
		ff.vender(this.venda);
	}

	// check atributos

	@Test
	public void checkCliente() {
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA).getCliente().getNome(),
				this.cliente.getNome());
	}

	@Test
	public void checkPreco() {
		Venda v = ff.buscarVenda(CODIGO_VENDA);
		System.out.println("//////////////");
		System.out.println("Venda: " + v);
		System.out.println("Preço: " + v.getValor());
		System.out.println("//////////////");
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA).getValor(),
				this.venda.getValor(), 0.1);
	}

	@Test
	public void checkProduto() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getItems().get(0)
				.getProduto().getCodigo(), this.item.getProduto().getCodigo());
	}

	@Test
	public void checkHora() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getHours(),
				this.venda.getDataVenda().getHours());
	}

	@Test
	public void checkMinutos() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getMinutes(),
				this.venda.getDataVenda().getMinutes());
	}

	@Test
	public void checkDia() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getDate(),
				this.venda.getDataVenda().getDate());
	}

	@Test
	public void checkAno() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getYear(),
				this.venda.getDataVenda().getYear());
	}

	@Test
	public void checkDiaDaSemana() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getDay(),
				this.venda.getDataVenda().getDay());
	}

	@Test
	public void checkMes() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getMonth(),
				this.venda.getDataVenda().getMonth());
	}

	@Test
	public void checkDiaPagamento() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getDate(),
				this.venda.getDataPagamento().getDate());
	}

	@Test
	public void checkMesPagamento() {
		assertEquals(
				ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getMonth(),
				this.venda.getDataPagamento().getMonth());
	}

	@Test
	public void checkAnoPagamento() {
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getYear(),
				this.venda.getDataPagamento().getYear());
	}

}
