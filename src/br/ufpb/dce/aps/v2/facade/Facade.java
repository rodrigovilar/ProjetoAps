package br.ufpb.dce.aps.v2.facade;

import br.ufpb.dce.aps.v2.entitys.Login;
import br.ufpb.dce.aps.v2.model.ClienteModel;
import br.ufpb.dce.aps.v2.model.SessionModel;
import br.ufpb.dce.aps.v2.model.VendaModel;
import br.ufpb.dce.aps.v2.model.VendedorModel;
import br.ufpb.dce.aps.v2.model.interfaces.Model;

public class Facade {
	
	private Model	c;
	
	public void setControllerCliente() {
		this.c = new ClienteModel();
	}
	
	public void setControllerVenda() {
		this.c = new VendaModel();
	}
	
	public void setControllerSession(){
		this.c = new SessionModel();
	}
	
	public void setControllerVendendor(){
		this.c = new VendedorModel();
	}

	public void criarSessao(Login l) {
		c.create(l);
	}
	
}
