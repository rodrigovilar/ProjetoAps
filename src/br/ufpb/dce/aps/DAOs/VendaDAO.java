package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Venda;

public class VendaDAO extends DAO <Venda>{

	public VendaDAO(EntityManager m, Class <Venda> classe) {
		super(m, classe);
		// TODO Auto-generated constructor stub
	}

	
}