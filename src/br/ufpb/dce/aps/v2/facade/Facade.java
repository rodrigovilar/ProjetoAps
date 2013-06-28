package br.ufpb.dce.aps.v2.facade;

import br.ufpb.dce.aps.v2.controllers.ClienteController;
import br.ufpb.dce.aps.v2.controllers.SessionController;
import br.ufpb.dce.aps.v2.controllers.VendaController;
import br.ufpb.dce.aps.v2.controllers.VendedorController;
import br.ufpb.dce.aps.v2.controllers.interfaces.Controller;

public class Facade {
	
	private Controller	c;
	
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
	
}
