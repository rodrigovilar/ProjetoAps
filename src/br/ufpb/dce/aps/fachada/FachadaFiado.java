package br.ufpb.dce.aps.fachada;

import br.ufpb.dce.aps.controles.ControleCadastro;
import br.ufpb.dce.aps.controles.ControleCliente;
import br.ufpb.dce.aps.controles.ControleContas;
import br.ufpb.dce.aps.controles.ControleNotificacao;
import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.controles.ControleVendas;
import br.ufpb.dce.aps.controles.ControleVendedor;

public class FachadaFiado {

	private ControleVendas controlVenda =  new ControleVendas();

	private ControleCliente controlCliente = new ControleCliente();

	private ControleVendedor controlVendedor =  new ControleVendedor();

	private ControleProduto controlProd = new ControleProduto();

	private ControleNotificacao controlNot = new ControleNotificacao();

	private ControleContas controlCont = new ControleContas();

	private ControleCadastro controlCadas = new ControleCadastro();
	
	public ControleProduto controleProdutos(){
		return this.controlProd; 
	}

	public ControleCadastro ControleCadastro() {
		// TODO Auto-generated method stub
		return this.controlCadas;
	}

	public ControleContas ControleContas() {
		// TODO Auto-generated method stub
		return this.controlCont;
	}

	public ControleNotificacao ControleNotificacao() {
		// TODO Auto-generated method stub
		return this.controlNot;
	}
	public ControleCliente ControleCliente1(){
		return this.controlCliente;
		
	}
	public ControleVendas ControleVenda(){
		return this.controlVenda;
	}

	public ControleCliente ControleCliente() {
		// TODO Auto-generated method stub
	 return this.controlCliente;
	}

}
