package br.ufpb.dce.aps.entidades;
import java.util.ArrayList;
import java.util.List;


public class Venda {

	private short idVenda;

	private Cliente cliente;

	private List<Produto> produtos = new ArrayList<Produto>();

	private float valor;

	public short getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(short idVenda) {
		this.idVenda = idVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
