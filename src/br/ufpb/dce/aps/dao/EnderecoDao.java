package br.ufpb.dce.aps.dao;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Endereco;

public class EnderecoDao extends Dao<Endereco> {
	public EnderecoDao(EntityManager manager, Class<Endereco> classe) {
		super(manager, classe);
	}
}