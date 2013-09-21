
package br.ufpb.dce.aps.controles;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufpb.dce.aps.entidades.Cobranca;
import br.ufpb.dce.aps.exception.ValorInvalidoException;
import br.ufpb.dce.aps.exception.VendaException;

public class ControleCobranca {
	public Map<String,Cobranca> cobrançasPagas = new HashMap<String, Cobranca>();
	public Map<String, Cobranca> mapaDeCobrancas = new HashMap<String, Cobranca>();

	// não posso ter uma outra cobrança com um mesmo id de venda
	public void addCobranca(Cobranca cobranca, String idVenda)
			throws VendaException {
		if (!mapaDeCobrancas.containsKey(idVenda)) {
			this.mapaDeCobrancas.put(idVenda, cobranca);
		} else {
			throw new VendaException("venda exception na cobrança");
		}
	}

	// A vista
	public void pagarCobranca(String idCobranca){
		Cobranca cobranca = this.mapaDeCobrancas.get(idCobranca);
		this.cobrançasPagas.put(idCobranca, cobranca);
		this.mapaDeCobrancas.remove(idCobranca);
		cobranca.getVenda().setDataPagamento(new Date());		
	}
	

	
	public Cobranca exibirCobranca(String idVenda) {
		return this.mapaDeCobrancas.get(idVenda);
	}

	public Map<String, Cobranca> listarTodasAsCobrancas() {
		return this.mapaDeCobrancas;
	}


	// puxar dados do cliente para o controle de vendas
	public List<Cobranca> listarDebitosDeCliente(String CPF) throws ValorInvalidoException{
		if (CPF.trim().matches("[0-9]{11}") && CPF.length() == 11) {
			List<Cobranca> lista = new LinkedList<Cobranca>();
			for (Cobranca c : this.mapaDeCobrancas.values())
				if (c.getVenda().getCliente().getCPF() == CPF)
					lista.add(c);					
			return lista;
		}
		throw new ValorInvalidoException("CPF inválido");
	}
}
