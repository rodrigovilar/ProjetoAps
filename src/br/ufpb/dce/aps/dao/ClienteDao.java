package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Cliente;

public class ClienteDao extends Dao<Cliente> {
	public ClienteDao(EntityManager manager, Class<Cliente> classe) {
		super(manager, classe);
	}
}