package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;


public class DAO<T> {

	private final EntityManager m;
	private final Class<T> classe;
	
	public DAO(EntityManager m , Class<T> classe){
		this.m = m;
		this.classe = classe;
	}
	
	public void adicionar(Object o){
		// abre uma transação
		m.getTransaction().begin();
		m.persist(o);
		m.getTransaction().commit();
		
	}
	
	public void remover(Object o){
		m.getTransaction().begin();
		m.remove(o);
		m.getTransaction().commit();
	}
	
	public T procurar(String id){
		return m.getReference(classe,id);
	}
	
	public List<T> listarTodos(){
		return m.createQuery("select t from "+ classe.getName() +  " t").getResultList();
	}
}
