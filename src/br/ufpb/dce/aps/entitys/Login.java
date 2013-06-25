package br.ufpb.dce.aps.entitys;

import br.ufpb.dce.aps.entity.interfaces.Entity;

public class Login implements Entity {
	private String	username, password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
