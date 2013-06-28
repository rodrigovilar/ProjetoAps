package br.ufpb.dce.aps.teste;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.v2.entitys.Login;
import br.ufpb.dce.aps.v2.facade.Facade;

public class TesteProjeto {
	public Facade	f;
	public Login	l;
	
	@Before
	public void setUp() {
		f = new Facade();
		l = new Login();
	}
	
	private void criaLogin() {
		l.setUsername("admin");
		l.setPassword("admin");
	}
	
	@Test
	public void testaInicioDaSessao() {
		criaLogin();
		f.setControllerSession();
		f.criarSessao(l);
	}
	
}