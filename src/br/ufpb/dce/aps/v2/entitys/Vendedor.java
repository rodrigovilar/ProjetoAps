package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;
import br.ufpb.dce.aps.v2.entity.interfaces.Pessoa;

public class Vendedor extends Pessoa implements Entity {
	private Login	login;
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
}
