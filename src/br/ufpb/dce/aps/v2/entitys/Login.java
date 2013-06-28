package br.ufpb.dce.aps.v2.entitys;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

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
