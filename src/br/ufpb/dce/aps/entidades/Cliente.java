package br.ufpb.dce.aps.entidades;


public class Cliente extends Pessoa {

	private Data dataCobranca;

	private Conta conta;

	public void setCpf(String cpf) {
		this.cpf=cpf;
		
	}

}
