package br.ufpb.dce.aps.controles;

import br.ufpb.dce.aps.entidades.Cobranca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class ControleCobranca {

	public Map<String , Cobranca> mapaDeCobranças = 
			new HashMap <String,Cobranca>();	

	//não posso ter uma outra cobrança com um mesmo id de venda
	public void addCobranca(Cobranca cobranca, String idVenda) {
		
		this.mapaDeCobranças.put(idVenda, cobranca);
		
	}

	public Cobranca exibirCobranca(String idVenda) {
		return this.mapaDeCobranças.get(idVenda);
	}

	

}
