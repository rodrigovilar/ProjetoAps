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
	
	public void adicionar(T t){
		// abre uma transação
		m.getTransaction().begin();
		m.persist(t);
		m.getTransaction().commit();
		
	}
	
	public void remover(T t){
		m.getTransaction().begin();
		m.remove(t);
		m.getTransaction().commit();
	}
	public void atualizar(T t){
		m.getTransaction().begin();
		m.merge(t);
		m.getTransaction().commit();
	}
	
	public T procurar(String id){
		return m.getReference(classe,id);
	}
	
	public T procurar(T t){
		return m.getReference(classe, t);
	}
	public List<T> listarTodos(){
		return m.createQuery("select t from "+ classe.getName() +  " t").getResultList();
	}
}
