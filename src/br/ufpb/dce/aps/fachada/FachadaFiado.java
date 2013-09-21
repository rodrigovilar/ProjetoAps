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
import br.ufpb.dce.aps.exception.CPFInvalidoException;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ClienteNaoCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;
import br.ufpb.dce.aps.exception.VendaException;

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
	public void addCobranca(Cobranca cobranca, String idVenda)
			throws VendaException {
		this.controleCobranca.addCobranca(cobranca, idVenda);
	}

	public Cobranca exibirCobranca(String idVenda) {
		return this.controleCobranca.exibirCobranca(idVenda);
	}

	public List<Cobranca> listarDebitosDoCliente(String CPF) {
		return this.controleCobranca.listarDebitosDeCliente(CPF);
	}

	// controle Vendas
	public Venda buscarVenda(String idVenda) {
		return this.controlVenda.buscarVenda(idVenda);
	}

	public boolean vender(Venda venda) {
		return this.controlVenda.vender(venda);
	}

	public boolean removerVenda(String idVenda) {
		return this.controlVenda.removerVenda(idVenda);
	}

	public List<Venda> listarVendasRalizadas() {
		return this.controlVenda.listarVendasRealizadas();
	}

	// Controle de produtos

	public void cadastrarProduto(Produto p) throws ProdutoJaCadastradoException {
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

	public List<Produto> exibirEstoque() {
		return this.controlProduto.exibirEstoqueDeProdutos();
	}

	// controle de clientes
	public void cadastrarCliente(Cliente c)
			throws ClienteJaCadastradoException, CPFInvalidoException, ClienteNaoCadastradoException {
		this.controlCliente.cadastrarCliente(c);

	}

	public boolean removerCliente(String cpf) throws CPFInvalidoException,
			ClienteNaoCadastradoException {
		return this.controlCliente.removerCliente(cpf);
	}

	public Cliente buscarCliente(String cpf) throws CPFInvalidoException,
			ClienteNaoCadastradoException {
		return this.controlCliente.buscarCliente(cpf);

	}

	public List<Cliente> listarClientes() {
		return this.controlCliente.listarClientes();
	}
}
