package br.ufpb.dce.aps.projeto;
public class ControleGerFiado {

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
