package br.ufpb.dce.aps;

import java.util.ArrayList;

public class GerenteDeProdutos {
	ArrayList<Produto>	produtos	= new ArrayList<Produto>();
	
	public boolean adicionarProduto(int c, int q, int t, String nome) {
		Produto p = new Produto(c, q, t, nome);
		if (!(produtos.contains(p))) {
			return produtos.add(p);
		}
		else {
			return false;
		}
	}
	
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
