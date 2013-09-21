
package br.ufpb.dce.aps.controles;

import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.exception.VendaException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ControleCobranca {

	public Map<String, Cobranca> mapaDeCobranças = new HashMap<String, Cobranca>();

	// não posso ter uma outra cobrança com um mesmo id de venda
	public void addCobranca(Cobranca cobranca, String idVenda)
			throws VendaException {
		if (!mapaDeCobranças.containsKey(idVenda)) {
			this.mapaDeCobranças.put(idVenda, cobranca);
		} else {
			throw new VendaException("venda exception na cobrança");
		}
	}

	// A vista
	public boolean pagarCobranca(Cobranca c){
		
		return false;
	}
	
	public Cobranca exibirCobranca(String idVenda) {
		return this.mapaDeCobranças.get(idVenda);
	}

	public Map<String, Cobranca> listarTodasAsCobrancas() {
		return this.mapaDeCobranças;
	}


	// puxar dados do cliente para o controle de vendas
	public List<Cobranca> listarDebitosDeCliente(String CPF) throws ValorInvalidoException{
		if (CPF.trim().matches("[0-9]{11}") && CPF.length() == 11) {
			List<Cobranca> lista = new LinkedList<Cobranca>();
			for (Cobranca c : this.mapaDeCobranças.values())
				if (c.getVenda().getCliente().getCPF() == CPF)
					lista.add(c);					
			return lista;
		}
		throw new ValorInvalidoException("CPF inválido");
	}
}
