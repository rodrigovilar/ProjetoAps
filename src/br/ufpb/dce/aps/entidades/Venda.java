package br.ufpb.dce.aps.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda {

	@Id
	private String idVenda;

	@ManyToOne
	private Cliente cliente;
	
	// mappedby so com relacionamento bidirecional
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<Item>();

	private float valor;

	@Temporal(TemporalType.DATE)
	private Date dataVenda;

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return itens;
	}

	public void setItems(List<Item> itens) {
		this.itens = itens;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
