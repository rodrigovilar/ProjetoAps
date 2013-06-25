package br.ufpb.dce.aps.controle.interfaces;

import br.ufpb.dce.aps.entidade.interfaces.Entity;

public interface Controller {
	public void index();
	
	 public void criar(Entity entidade);
	 /* 
	 * padrao singleton ou abstract factory
	 */
	public void get_criado();
	
	public void get_by_id(int index);
	
	public void delete_by_id(int index);
}
