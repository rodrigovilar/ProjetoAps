package br.ufpb.dce.aps.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufpb.dce.aps.entidades.Produto;

public class ProdutoDAO {

	private final DAO <Produto> dao;
	
	public ProdutoDAO(EntityManager e){
		dao = new DAO<Produto>(e , Produto.class);
	}
	
	public void adicionar(Produto c){
		this.dao.adicionar(c);
	}
	
	public void remover(Produto p){
		this.dao.remover(p);
	}
	
	public Produto pesquisar(String id){
		return this.dao.procurar(id);
	}
	public Produto pesquisar(Produto p){
		return this.dao.procurar(p);
	}
	
	public void atualizar(Produto p){
		this.dao.atualizar(p);
	}
	
	public List<Produto> listarTodos(){
		return this.dao.listarTodos();
	}
}