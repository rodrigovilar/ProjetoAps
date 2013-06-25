package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public class Session implements Entity {
	private int				id;
	private Vendedor	vendedor;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		
	}
	
}
