package br.ufpb.dce.aps.DAOs;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Cliente;

public class ClienteDAO extends DAO<Cliente> {

	public ClienteDAO(EntityManager m, Class<Cliente> classe) {
		super(m, classe);
		// TODO Auto-generated constructor stub
	}

	
}
