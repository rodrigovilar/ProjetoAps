package br.ufpb.dce.aps.v2.entitys;

import java.util.List;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public class Venda implements Entity {
	private Entity				vendedor;
	private Entity				cliente;
	private List<Entity>	produtos;
	private double				valor;
	private Notification	notification;
	
	public Notification getNotification() {
		return notification;
	}
	
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
	public Entity getCliente() {
		return cliente;
	}
	
	public void setCliente(Entity cliente) {
		this.cliente = cliente;
	}
	
	public List<Entity> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Entity> produtos) {
		this.produtos = produtos;
	}
	
	public Entity getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Entity vendedor) {
		this.vendedor = vendedor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
