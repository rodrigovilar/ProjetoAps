package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public class Notification implements Entity {
	private int	codigo;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
