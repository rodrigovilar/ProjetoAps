package br.ufpb.dce.aps.entidades;
import java.util.Date;
import java.util.List;


public class Conta {

	private List<Produto> produtosComprados;

	private Date dataCompra;

	private float valorCompra;

	public List<Produto> getProdutosComprados() {
		return produtosComprados;
	}

	public void setProdutosComprados(List<Produto> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	
}
