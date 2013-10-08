package br.ufpb.dce.aps.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Venda {

	@Id
	private String idVenda;

	@ManyToOne
	private Cliente cliente;
	
	// mappedby so com relacionamento bidirecional
	
	@OneToMany(cascade=CascadeType.ALL) @JoinColumn(name = "itemID") //(mappedBy = "venda", cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<Item>();

	private float valor;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;

	@Temporal(TemporalType.TIMESTAMP)
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
