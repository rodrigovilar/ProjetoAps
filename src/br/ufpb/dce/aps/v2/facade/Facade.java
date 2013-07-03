package br.ufpb.dce.aps.v2.facade;

import br.ufpb.dce.aps.v2.entitys.Login;
import br.ufpb.dce.aps.v2.model.ClienteController;
import br.ufpb.dce.aps.v2.model.SessionController;
import br.ufpb.dce.aps.v2.model.VendaController;
import br.ufpb.dce.aps.v2.model.VendedorController;
import br.ufpb.dce.aps.v2.model.interfaces.Model;

public class Facade {
	
	private Model	c;
	
	public void setControllerCliente() {
		this.c = new ClienteController();
	}
	
	public void setControllerVenda() {
		this.c = new VendaController();
	}
	
	public void setControllerSession(){
		this.c = new SessionController();
	}
	
	public void setControllerVendendor(){
		this.c = new VendedorController();
	}

	public void criarSessao(Login l) {
		c.create(l);
	}
	
}
