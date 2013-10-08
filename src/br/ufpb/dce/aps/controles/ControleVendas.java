package br.ufpb.dce.aps.controles;

import java.util.List;

import br.ufpb.dce.aps.dao.VendaDao;
import br.ufpb.dce.aps.entidades.Venda;
import br.ufpb.dce.aps.exception.VendaException;
import br.ufpb.dce.aps.infra.JPAUtil;

public class ControleVendas {

	private VendaDao dao;

	public ControleVendas() {
		dao = new VendaDao(JPAUtil.getInstance().getEntityManager(),
				Venda.class);
	}

	public boolean vender(Venda venda) throws VendaException {
		if (this.buscarVenda(venda.getIdVenda()) == null) {
			this.dao.adicionar(venda);
			return true;
		}

		// n�o pode vender duas vezes a mesma coisa
		throw new VendaException("Venda Exception");
	}

	public boolean removerVenda(String idVenda) {
		Venda venda = buscarVenda(idVenda);
		
		
		this.dao.remover(venda);
		return true;
	}

	public Venda buscarVenda(String idVenda) {
		return this.dao.procurar(idVenda);
	}

	public List<Venda> listarVendasRealizadas() {
		return this.dao.listarTodos();
	}
}
