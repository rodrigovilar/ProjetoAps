package br.ufpb.dce.aps.fachada;

import br.ufpb.dce.aps.controles.ControleCadastro;
import br.ufpb.dce.aps.controles.ControleCliente;
import br.ufpb.dce.aps.controles.ControleContas;
import br.ufpb.dce.aps.controles.ControleNotificacao;
import br.ufpb.dce.aps.controles.ControleProduto;
import br.ufpb.dce.aps.controles.ControleVendas;
import br.ufpb.dce.aps.controles.ControleVendedor;

public class FachadaFiado {

	private ControleVendas controlVenda;

	private ControleCliente controlCliente;

	private ControleVendedor controlVendedor;

	private ControleProduto controlProd = new ControleProduto();

	private ControleNotificacao controlNot;

	private ControleContas controlCont;

	private ControleCadastro controlCadas;
	
	public ControleProduto controleProdutos(){
		return this.controlProd; 
	}

}
