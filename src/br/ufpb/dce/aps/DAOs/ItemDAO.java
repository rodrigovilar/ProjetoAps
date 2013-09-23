package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Item;

public class ItemDAO {

	private final DAO <Item> dao;
	
	public ItemDAO(EntityManager e){
		dao = new DAO<Item>(e , Item.class);
	}
	
	public void adicionar(Item i){
		this.dao.adicionar(i);
	}
	
	public void remover(Item i){
		this.dao.remover(i);
	}
	
	public Item pesquisar(String id){
		return this.dao.procurar(id);
	}
	public Item pesquisar(Item i){
		return this.dao.procurar(i);
	}
	
	public void atualizar(Item i){
		this.dao.atualizar(i);
	}
	
	public List<Item> listarTodos(){
		return this.dao.listarTodos();
	}
}