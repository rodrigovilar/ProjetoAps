package br.ufpb.dce.aps.entitys;

import java.util.List;

import br.ufpb.dce.aps.entity.interfaces.Entity;
import br.ufpb.dce.aps.entity.interfaces.Pessoa;

public class Cliente extends Pessoa implements Entity {
	
	private List<Entity> conta;

	public List<Entity> getVenda() {
		return conta;
	}

	public void setVenda(List<Entity> conta) {
		this.conta = conta;
	}
}
