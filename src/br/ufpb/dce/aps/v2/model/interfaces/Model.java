package br.ufpb.dce.aps.v2.model.interfaces;

import java.util.List;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;

public interface Model {
	
	public List<Entity> index();
	
	public void create(Entity entidade);
	
	public Entity get(int index);
	
	public void update(int index, Entity entity);
	
	public Entity delete(int index);
}
