package br.ufpb.dce.aps.DAOs;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Endereco;

public class EnderecoDAO extends DAO<Endereco> {

	public EnderecoDAO(EntityManager m, Class <Endereco>classe) {
		super(m, classe);
		// TODO Auto-generated constructor stub
	}

}
