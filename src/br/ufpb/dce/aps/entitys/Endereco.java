package br.ufpb.dce.aps.entitys;
public class Endereco {
	

	private String rua;

	private String referencia;

	private String numero;

	private String bairro;

	public Endereco(String numero, String rua, String bairro, String referencia) {
		this.referencia=referencia;
		this.rua=rua;
		this.bairro=bairro;
		this.numero=numero;
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
}
