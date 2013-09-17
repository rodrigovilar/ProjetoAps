package br.ufpb.dce.aps.teste;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.sun.imageio.plugins.common.I18N;
import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

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
}
