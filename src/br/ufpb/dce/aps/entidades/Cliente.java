package br.ufpb.dce.aps.entidades;

import java.util.Date;


public class Cliente extends Pessoa {

	private Date dataCobranca;
	private Conta conta;

	
	public Date getDataCobranca() {
		return dataCobranca;
	}

	public void setDataCobranca(Date dataCobranca) {
		this.dataCobranca = dataCobranca;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	
	

}
