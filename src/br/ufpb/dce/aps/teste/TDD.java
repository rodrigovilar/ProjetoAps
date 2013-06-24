package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dce.aps.entidades.Session;
import br.ufpb.dce.aps.exception.PasswordInvalidException;
import br.ufpb.dce.aps.exception.UsernameInvalidException;

public class TDD {
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void test_001() {
		/* Login */
		assertTrue(Session.login("admin", " "));
	}
	
	@Test(expected = UsernameInvalidException.class)
	public void test_002() {
		/* Login com exception em username */
		assertTrue(Session.login("admina", " "));
	}
	
	@Test(expected = PasswordInvalidException.class)
	public void test_003() {
		/* Login com exception em password */
		assertTrue(Session.login("admin", "1"));
	}
	
}
