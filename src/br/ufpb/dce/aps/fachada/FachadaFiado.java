package br.ufpb.dce.aps.fachada;

import java.util.List;

import br.ufpb.dce.aps.controles.ControleCliente;
import br.ufpb.dce.aps.controles.ControleContas;
import br.ufpb.dce.aps.controles.ControleNotificacao;
import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.controles.ControleVendas;
import br.ufpb.dce.aps.controles.ControleVendedor;
import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.exception.ClienteJaCadastradoException;
import br.ufpb.dce.aps.exception.ProdutoJaCadastradoException;

public class FachadaFiado {

	private ControleVendas			controlVenda;

	private ControleCliente			controlCliente;

	private ControleVendedor		controlVendedor;

	private ControleProduto			controlProd;

	private ControleNotificacao	controlNot;

	private ControleContas			controlCont;

	public FachadaFiado() {
		this.controlVenda = new ControleVendas();
		this.controlCliente = new ControleCliente();
		this.controlVendedor = new ControleVendedor();
		this.controlProd = new ControleProduto();
		this.controlNot = new ControleNotificacao();
		this.controlCont = new ControleContas();

	}

	// Controle de produtos

	public void cadastrarProduto(String nome, int cod, float preco) {
		try {
			this.controlProd.cadastrarProduto(nome, cod, preco);
		}
		catch (ProdutoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Produto buscarProduto(int cod) {
		return this.controlProd.buscarProduto(cod);
	}

	public boolean removerProduto(int cod) {
		return this.controlProd.removerProduto(cod);
	}

	public List<Produto> exibirEstoqueDeProdutos() {
		return this.controlProd.exibirEstoqueDeProdutos();
	}

	// controle de clientes
	public void cadastrarCliente(String numero, String nome, String rua,
			String bairro, String telefone, String referencia, String cpf) throws ClienteJaCadastradoException {
		this.controlCliente.cadastrarCliente(numero, nome, rua, bairro, telefone,
					referencia, cpf);
			
	}

	public boolean removerCliente(String cpf) {
		return this.controlCliente.removerCliente(cpf);
	}

	public Cliente buscarCliente(String cpf) {
		return this.controlCliente.buscarCliente(cpf);

	}

	public ControleCliente ControleCliente() {
		return this.controlCliente;
	}

}
