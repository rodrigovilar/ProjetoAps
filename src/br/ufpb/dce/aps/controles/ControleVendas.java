package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Cliente;
import br.ufpb.dce.aps.entidades.Produto;
import br.ufpb.dce.aps.entidades.Venda;

public class ControleVendas {

	private List<Venda> listaVendas = new LinkedList<Venda>();

	public boolean venda(Venda venda) {

		return this.listaVendas.add(venda);
	}

	public boolean removerProduto(Venda venda) {
		
		return this.listaVendas.remove(venda);
	}


	public List<Venda> listarVendasRealizadas() {
		return this.listaVendas;
	}

}
