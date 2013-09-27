package br.ufpb.dce.aps.controles;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.VendaException;

public class ControleVendas {
	
	private List<Venda> listaVendas = new LinkedList<Venda>();

	public boolean vender(Venda venda) throws VendaException {
		if (this.buscarVenda(venda.getIdVenda()) == null)
			return this.listaVendas.add(venda);
		else
			// não pode vender duas vezes a mesma coisa
			throw new VendaException("Venda Exception");
	}

	public boolean removerVenda(String idVenda) {
		return this.listaVendas.remove(this.buscarVenda(idVenda));

	}

	public Venda buscarVenda(String idVenda) {
		for (Venda venda : this.listaVendas)
			if (venda.getIdVenda() == idVenda)
				return venda;
		return null;
	}

	public List<Venda> listarVendasRealizadas() {
		return this.listaVendas;
	}

}
