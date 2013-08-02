package br.ufpb.dce.aps.entidades;

import java.util.Calendar;


public class Cobranca {
	
	private Calendar dataPagamento;
	private Venda venda ;
	private boolean pagamentoEfetuado;
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public boolean isPagamentoEfetuado() {
		return pagamentoEfetuado;
	}
	public void setPagamentoEfetuado(boolean pagamentoEfetuado) {
		this.pagamentoEfetuado = pagamentoEfetuado;
	}
	
	
}
