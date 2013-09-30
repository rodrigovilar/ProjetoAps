package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Cobranca;

public class CobrancaDao extends Dao<Cobranca> {
	public CobrancaDao(EntityManager manager, Class<Cobranca> classe) {
		super(manager, classe);
	}
}