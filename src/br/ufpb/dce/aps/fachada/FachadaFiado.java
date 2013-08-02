package br.ufpb.dce.aps.fachada;

import java.util.List;

import br.ufpb.dce.aps.controles.ControleCliente;

import br.ufpb.dce.aps.controles.ControleCobranca;
import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.controles.ControleVendas;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;

public class FachadaFiado {

	private ControleVendas controlVenda;

	private ControleCliente controlCliente;

	private ControleProduto controlProduto;

	private ControleCobranca controleCobranca;

	

	public FachadaFiado() {
		this.controlVenda = new ControleVendas();
		this.controlCliente = new ControleCliente();
		
		this.controlProduto = new ControleProduto();
		this.controleCobranca = new ControleCobranca();
		

	}
	// controleCobranca
	public void addCobranca(List<Cobranca> cobranca, String idVenda){
		 this.controleCobranca.addCobranca(cobranca, idVenda);
	}
	public List<Cobranca> exibirCobranca(String idVenda){
		return this.controleCobranca.exibirCobranca(idVenda);
	}
	// controleVendas
	public boolean venda(Venda venda){
		return this.controlVenda.venda(venda);
	}
	public boolean removerVenda(Venda venda){
		return this.controlVenda.removerProduto(venda);
	}
	
	public List<Venda> listarVendasRalizadas(){
		return this.controlVenda.listarVendasRealizadas();
	}

	// Controle de produtos

	public void cadastrarProduto(Produto p)
			throws ProdutoJaCadastradoException {
		this.controlProduto.cadastrarProduto(p);
	}

	public Produto buscarProduto(String cod) {
		return this.controlProduto.buscarProduto(cod);
	}

	public boolean removerProduto(String cod) {
		return this.controlProduto.removerProduto(cod);
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		return this.controlProduto.exibirEstoqueDeProdutos();
	}

	public int getNumeroDeProdutos() {
		return this.controlProduto.getNumeroDeProdutos();
	}
	public List<Produto> exibirEstoque(){
		return this.controlProduto.exibirEstoqueDeProdutos();
	}

	// controle de clientes
	public void cadastrarCliente(Cliente c)
			throws ClienteJaCadastradoException {
		this.controlCliente.cadastrarCliente(c);

	}

	public boolean removerCliente(String cpf) {
		return this.controlCliente.removerCliente(cpf);
	}

	public Cliente buscarCliente(String cpf) {
		return this.controlCliente.buscarCliente(cpf);

	}

	public List<Cliente> listarClientes() {
		return this.controlCliente.listarClientes();
	}
}
