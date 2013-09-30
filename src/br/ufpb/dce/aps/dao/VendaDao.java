package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Venda;

public class VendaDao extends Dao<Venda> {
	public VendaDao(EntityManager manager, Class<Venda> classe) {
		super(manager, classe);
	}
}