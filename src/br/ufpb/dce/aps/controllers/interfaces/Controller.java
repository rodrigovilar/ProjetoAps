package br.ufpb.dce.aps.controllers.interfaces;

import java.util.List;

import br.ufpb.dce.aps.entity.interfaces.Entity;

public interface Controller {
	public List<Entity> index();
	
	public void criar(Entity entidade);
	
	/*
	 * padrao singleton ou abstract factory
	 */
	public Entity get_criado();
	
	public Entity get_by_id(int index);
	
	public Entity delete_by_id(int index);
}
