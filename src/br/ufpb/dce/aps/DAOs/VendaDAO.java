package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Venda;

public class VendaDAO {

	private final DAO <Venda> dao;
	
	public VendaDAO(EntityManager e){
		dao = new DAO<Venda>(e , Venda.class);
	}
	
	public void adicionar(Venda v){
		this.dao.adicionar(v);
	}
	
	public void remover(Venda v){
		this.dao.remover(v);
	}
	
	public Venda pesquisar(String id){
		return this.dao.procurar(id);
	}
	public Venda pesquisar(Venda v){
		return this.dao.procurar(v);
	}
	
	public void atualizar(Venda v){
		this.dao.atualizar(v);
	}
	
	public List<Venda> listarTodos(){
		return this.dao.listarTodos();
	}
}