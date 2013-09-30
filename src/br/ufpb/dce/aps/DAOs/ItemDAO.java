package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Item;

public class ItemDAO  extends DAO<Item>{

	public ItemDAO(EntityManager m, Class <Item>classe) {
		super(m, classe);
		// TODO Auto-generated constructor stub
	}

	
}