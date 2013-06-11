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

	private ControleCadastro ControleCadastro() {
		// TODO Auto-generated method stub
		return controlCadas;
	}

	private ControleContas ControleContas() {
		// TODO Auto-generated method stub
		return controlCont;
	}

	private ControleNotificacao ControleNotificacao() {
		// TODO Auto-generated method stub
		return controlNot;
	}

}
