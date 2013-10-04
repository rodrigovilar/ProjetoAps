package br.ufpb.dce.aps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.SQLGrammarException;

public class Dao<T> {
	protected EntityManager manager;
	protected Class<T> classe;

	public Dao(EntityManager manager, Class<T> classe) {
		this.manager = manager;
		this.classe = classe;
	}

	public void adicionar(T t) {
		// abre uma transação
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}

	public void remover(T t) {
		manager.getTransaction().begin();
		manager.remove(t);
		manager.getTransaction().commit();
	}

	public void atualizar(T t) {
		manager.getTransaction().begin();
		manager.merge(t);
		manager.getTransaction().commit();
	}

	public T procurar(String id) {
		try {
			System.out.println("\n\nTRY\n\n");
			return manager.find(classe, id);
		} catch (EntityNotFoundException e) {
			return null;
		} catch (SQLGrammarException e) {
			return null;
		}
	}

	public T procurar(T t) {
		try {
			return manager.find(classe, t);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	public List<T> listarTodos() {
		return manager.createQuery("select t from " + classe.getName() + " t")
				.getResultList();
	}
}