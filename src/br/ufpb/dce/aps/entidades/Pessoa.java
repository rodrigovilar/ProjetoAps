package br.ufpb.dce.aps.entidades;


public class Pessoa {

	private String nome;
	private Endereco endereco;
	private String telefone;
	private String CPF;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCPF(){
		return this.CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	

}
