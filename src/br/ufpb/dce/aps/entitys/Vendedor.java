package br.ufpb.dce.aps.entitys;

import br.ufpb.dce.aps.entity.interfaces.Entity;
import br.ufpb.dce.aps.entity.interfaces.Pessoa;

public class Vendedor extends Pessoa implements Entity {
	private Login	login;
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
}
