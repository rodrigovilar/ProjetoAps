package br.ufpb.dce.aps.controle.interfaces;

import java.util.List;

import br.ufpb.dce.aps.entidade.interfaces.Entity;

public interface Controller {
	public void index();
	
	 public List<Entity> criar(Entity entidade);
	 /* 
	 * padrao singleton ou abstract factory
	 */
	public Entity get_criado();
	
	public Entity get_by_id(int index);
	
	public Entity delete_by_id(int index);
}
