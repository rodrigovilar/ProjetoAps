package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Produto;

public class ProdutoDao extends Dao<Produto> {
	public ProdutoDao(EntityManager manager, Class<Produto> classe) {
		super(manager, classe);
	}
}