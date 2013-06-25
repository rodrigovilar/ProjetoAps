package br.ufpb.dce.aps.teste;

import static org.junit.Assert.assertEquals;

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
	/**
	 * {index => listar}
	 * Sequencia de estimulos a serem feitos no sistema
	 * 
	 * projeto.aps.ufpb.br/ => login() 
	 * .../:index => login()
	 * .../:index => login() + Usuario N encontrado
	 * .../:index => login() + Senha errada
	 * ---------------------------------------------------
	 * .../venda/ => venda.index()
	 * .../venda/ => venda.index() + N encontrado
	 * .../venda/:index => venda.index()
	 * .../venda/:new => venda.criar_venda()
	 * .../venda/:new/:vendedor/:id => venda.get_venda_criada().set_vendedor()
	 * .../venda/:new/:vendedor/:id => venda.get_venda_criada().set_vendedor() + Vendedor n existe 
	 * .../venda/:new => venda.criar_venda() + Nao pode criar
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id)
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id) + Produto n existe
	 * .../venda/:new/:produto/:id => venda.get_venda_criada().adicionar_item(:produto/:id) + Produto n tem no estoque
	 * .../venda/:id => venda.get_by_id(:id)
	 * .../venda/:id => venda.get_by_id(:id) + Venda n existe
	 * .../venda/:id/:edit => venda.edit(:id)
	 * .../venda/:id/:edit => venda.edit(:id) + N pode editar
	 * .../venda/:id/:delete => venda.delete_by_id(:id)
	 * .../venda/:id/:delete => venda.delete_by_id(:id) + N pode deletar
	 * ---------------------------------------------------
	 * .../produto/ => venda.index()
	 * .../produto/ => venda.index() + N encontrado
	 * .../produto/:index => venda.index()
	 * .../produto/:new => venda.criar_venda()
	 * .../produto/:new => venda.criar_venda() + Nao pode criar
	 * .../produto/:id => venda.get_by_id(:id)
	 * .../produto/:id => venda.get_by_id(:id) + Produto n existe
	 * .../produto/:id/:edit => venda.edit(:id)
	 * .../produto/:id/:edit => venda.edit(:id) + N pode editar
	 * .../produto/:id/:delete => venda.delete_by_id(:id)
	 * .../produto/:id/:delete => venda.delete_by_id(:id) + N pode deletar
	 * ---------------------------------------------------
	 * */

	
	@Test
	public void test_001() {
		/* Login */
		assertEquals(null, f.login("admin", " "));
	}
	
	@Test(expected = UsernameInvalidException.class)
	public void test_002() {
		/* Login com exception em username */
		assertEquals(null, f.login("admina", " "));
	}
	
	@Test(expected = PasswordInvalidException.class)
	public void test_003() {
		/* Login com exception em password */
		assertEquals(null, f.login("admin", "1"));
	}
	
}