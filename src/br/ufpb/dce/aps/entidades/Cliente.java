package br.ufpb.dce.aps.entidades;


public class Cliente extends Pessoa {

	private Data dataCobranca;
	private String CPF;
	private Conta conta;

	public void setCPF(String CPF) {
		this.CPF = CPF;
		
	}

	public Data getDataCobranca() {
		return dataCobranca;
	}

	public void setDataCobranca(Data dataCobranca) {
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
