package br.ufpb.dce.aps.fachada;

import java.util.List;

import br.ufpb.dce.aps.controles.ControleCliente;

import br.ufpb.dce.aps.controles.ControleNotificacao;
import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.controles.ControleVendas;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;

public class FachadaFiado {

	private ControleVendas controlVenda;

	private ControleCliente controlCliente;

	

	private ControleProduto controlProd;

	private ControleNotificacao controlNot;

	

	public FachadaFiado() {
		this.controlVenda = new ControleVendas();
		this.controlCliente = new ControleCliente();
		
		this.controlProd = new ControleProduto();
		this.controlNot = new ControleNotificacao();
		

	}

	// Controle de produtos

	public void cadastrarProduto(Produto p)
			throws ProdutoJaCadastradoException {
		this.controlProd.cadastrarProduto(p);
	}

	public Produto buscarProduto(String cod) {
		return this.controlProd.buscarProduto(cod);
	}

	public boolean removerProduto(String cod) {
		return this.controlProd.removerProduto(cod);
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		return this.controlProd.exibirEstoqueDeProdutos();
	}

	public int getNumeroDeProdutos() {
		return this.controlProd.getNumeroDeProdutos();
	}
	public List<Produto> exibirEstoque(){
		return this.controlProd.exibirEstoqueDeProdutos();
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
