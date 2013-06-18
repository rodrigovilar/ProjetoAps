package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.exception.PasswordInvalidException;
import br.ufpb.dce.aps.exception.UsernameInvalidException;
import br.ufpb.dce.aps.fachada.FachadaFiado;

public class TDD {
	public FachadaFiado	f;
	
	@Before
	public void setUp() {
		f = new FachadaFiado();
	}
	
	@Test
	public void test_001() {
		/* Login */
		assertTrue(f.login("admin", " "));
	}
	
	@Test(expected = UsernameInvalidException.class)
	public void test_002() {
		/* Login com exception em username */
		assertTrue(f.login("admina", " "));
	}
	
	@Test(expected = PasswordInvalidException.class)
	public void test_003() {
		/* Login com exception em password */
		assertTrue(f.login("admin", "1"));
	}
	
	
	
}
