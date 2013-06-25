package br.ufpb.dce.aps.controle.interfaces;

public interface Controller {
	public void index();
	
	 public void criar();
	 /* 
	 * padrao singleton ou abstract factory
	 */
	public void get_criado();
	
	public void get_by_id();
	
	public void delete_by_id();
}
