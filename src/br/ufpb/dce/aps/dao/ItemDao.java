package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Item;

public class ItemDao extends Dao<Item> {
	public ItemDao(EntityManager manager, Class<Item> classe) {
		super(manager, classe);
	}
}