package br.ufpb.dce.aps.controles;

import br.ufpb.dce.aps.entidades.Cobranca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ControleCobranca {

	public Map<String , List<Cobranca>> mapaDeCobranças = new HashMap <String,List<Cobranca>>();	

	public void addCobranca(List<Cobranca> cobranca, String idVenda) {
		
		this.mapaDeCobranças.put(idVenda, cobranca);
		
	}

	public List<Cobranca> exibirCobranca(String idVenda) {
		return this.mapaDeCobranças.get(idVenda);
	}

	

}
