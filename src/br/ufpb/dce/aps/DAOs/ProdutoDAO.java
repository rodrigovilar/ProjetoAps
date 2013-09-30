package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Produto;

public class ProdutoDAO  extends DAO<Produto>{

	public ProdutoDAO(EntityManager m, Class <Produto> classe) {
		super(m, classe);
		// TODO Auto-generated constructor stub
	}

	
	
	
}