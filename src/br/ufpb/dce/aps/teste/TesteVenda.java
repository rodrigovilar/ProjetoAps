package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Endereco;
import br.ufpb.dce.aps.entidades.Item;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.VendaException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TesteVenda {

	private FachadaFiado ff;
	private Venda venda;
	private Item item;
	private Produto produto;
	private Endereco endereco;
	private Cliente cliente;
	
	public static final String CODIGO_PRODUTO = "sifu";
	public static final String CODIGO_VENDA= "naifu";
	public static final String CPF= "12345678901";
	
	@Before
	public void setUp(){
		
		this.endereco = new Endereco("12", "Rua", "Bairro", "referencia");
		
		this.cliente = new Cliente();
		this.cliente.setCPF(CPF);
		this.cliente.setNome("duza");
		this.cliente.setTelefone("098909879");
		this.cliente.setEndereco(this.endereco);
		
		this.produto = new Produto();
		this.produto.setCodigo(this.CODIGO_PRODUTO);
		this.produto.setNome("NAL");
		this.produto.setPreco(100);
		
		this.item = new Item();
		this.item.setProduto(this.produto);
		this.item.setQuantidade(20);
		
		List<Item> carrinhoDeCompras = new LinkedList<Item>();
		carrinhoDeCompras.add(this.item);
		
		this.venda = new Venda();
		this.venda.setIdVenda(this.CODIGO_VENDA);
		this.venda.setValor(400);
		this.venda.setItems(carrinhoDeCompras);
		this.venda.setCliente(this.cliente);
		this.venda.setDataVenda(new Date());
		this.venda.setDataPagamento(new Date());
		
		this.ff = new FachadaFiado();
		ff.vender(this.venda);
	}
	
	
	@Test
	public void checkVendaRealizada(){
		assertEquals(this.venda , ff.buscarVenda(venda.getIdVenda()));
	}

	@Test
	public void removerVenda(){
		ff.removerVenda(this.CODIGO_VENDA);
		assertNull(ff.buscarVenda(this.CODIGO_VENDA));
	}
	
	@Test
	public void listarVendas(){
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA),ff.listarVendasRalizadas().get(0));
	}
	
	@Test (expected = VendaException.class)
	public void excecaoDeVenda(){
		// nada de fazer a mesma venda duas vezes
		ff.vender(this.venda);
	}
	
	// check atributos
	
	@Test
	public void checkCliente(){
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA).getCliente(), this.cliente);
	}
	@Test
	public void checkPreco(){
		assertEquals(ff.buscarVenda(this.CODIGO_VENDA).getValor(), this.venda.getValor(),0.1);
	}
	
	@Test
	public void checkProduto(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getItems().get(0).getProduto(), this.item.getProduto());
	}
	
	@Test	
	public void checkHora(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getHours()
				, this.venda.getDataVenda().getHours());
	}
	
	@Test
	public void checkMinutos(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getMinutes(), 
				this.venda.getDataVenda().getMinutes());
	}
	
	@Test
	public void checkDia(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getDate(),
				this.venda.getDataVenda().getDate());
	}
	
	@Test
	public void checkAno(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getYear(),
				this.venda.getDataVenda().getYear());
	}
	
	@Test
	public void checkDiaDaSemana(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getDay(),
				this.venda.getDataVenda().getDay());
	}
	
	@Test
	public void checkMes(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataVenda().getMonth(),
				this.venda.getDataVenda().getMonth());
	}
	
	@Test
	public void checkDiaPagamento(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getDate(),
				this.venda.getDataPagamento().getDate());
	}
	
	@Test
	public void checkMesPagamento(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getMonth(),
				this.venda.getDataPagamento().getMonth());
	}
	
	@Test
	public void checkAnoPagamento(){
		assertEquals(ff.buscarVenda(CODIGO_VENDA).getDataPagamento().getYear()
				,this.venda.getDataPagamento().getYear());
	}
	
	
}
