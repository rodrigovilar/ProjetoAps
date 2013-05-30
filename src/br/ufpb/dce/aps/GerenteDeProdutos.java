package br.ufpb.dce.aps;

import java.util.ArrayList;

/*
 * 
 * Gerando CRUD
 * C => Create
 * R => Read
 * U => Update
 * D => Delete
 * 
 * */
public class GerenteDeProdutos {
	ArrayList<Produto>	produtos	= new ArrayList<Produto>();
	
	// Create
	public boolean adicionarProduto(int c, int q, int t, String nome) {
		Produto p = new Produto(c, q, t, nome);
		if (!(produtos.contains(p))) {
			return produtos.add(p);
		}
		else {
			return false;
		}
	}
	
	// Read
	public Produto getProduto(int c) {
		Produto p = new Produto(c);
		if (produtos.contains(p)) {
			return produtos.get(produtos.indexOf(p));
		}
		else
			return null;
	}
	
	// Update
	public boolean setProduto(int c, int q, int t, String nome) {
		Produto p = new Produto(c);
		if (produtos.contains(p)) {
			produtos.get(produtos.indexOf(p)).setNome(nome);
			produtos.get(produtos.indexOf(p)).setQuantidade(q);
			produtos.get(produtos.indexOf(p)).setTipo(t);
			return true;
		}
		else {
			return false;
		}
	}
	
	// Delete
	public boolean removerProduto(int c) {
		Produto p = new Produto(c);
		if (produtos.contains(p)) {
			produtos.remove(produtos.indexOf(p));
			if (!(produtos.contains(p))) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
}
