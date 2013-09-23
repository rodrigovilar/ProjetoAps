package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Cobranca;

public class CobrancaDAO {

	private final DAO <Cobranca> dao;
	
	public CobrancaDAO(EntityManager e){
		dao = new DAO<Cobranca>(e , Cobranca.class);
	}
	
	public void adicionar(Cobranca c){
		this.dao.adicionar(c);
	}
	
	public void remover(Cobranca c){
		this.dao.remover(c);
	}
	
	public Cobranca pesquisar(String id){
		return this.dao.procurar(id);
	}
	public Cobranca pesquisar(Cobranca c){
		return this.dao.procurar(c);
	}
	
	public void atualizar(Cobranca c){
		this.dao.atualizar(c);
	}
	
	public List<Cobranca> listarTodos(){
		return this.dao.listarTodos();
	}
}