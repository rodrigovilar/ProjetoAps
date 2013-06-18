package br.ufpb.dce.aps.entidades;

import java.util.Date;


public class Cliente extends Pessoa {

	private Date dataCobranca;
	private String CPF;
	private Conta conta;

	public void setCPF(String CPF) {
		this.CPF = CPF;
		
	}

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

	public String getCPF() {
		return CPF;
	}
	

}
