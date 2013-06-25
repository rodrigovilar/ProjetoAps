package br.ufpb.dce.aps.entitys;

import java.util.List;

import br.ufpb.dce.aps.entity.interfaces.Entity;
import br.ufpb.dce.aps.entity.interfaces.Pessoa;

public class Cliente extends Pessoa implements Entity {
	
	private List<Entity> venda;

	public List<Entity> getVenda() {
		return venda;
	}

	public void setVenda(List<Entity> venda) {
		this.venda = venda;
	}
}
