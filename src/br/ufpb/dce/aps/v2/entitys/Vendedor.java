package br.ufpb.dce.aps.v2.entitys;

import java.util.List;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;
import br.ufpb.dce.aps.v2.entity.interfaces.Pessoa;

public class Vendedor extends Pessoa implements Entity {
	private Login								login;
	private List<Notification>	notificactions;
	
	public List<Notification> getNotificactions() {
		return notificactions;
	}
	
	public void setNotificactions(List<Notification> notificactions) {
		this.notificactions = notificactions;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
}
