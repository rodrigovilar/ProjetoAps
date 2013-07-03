package br.ufpb.dce.aps.v2.model;

import java.util.List;

import br.ufpb.dce.aps.v2.entity.interfaces.Entity;
import br.ufpb.dce.aps.v2.model.interfaces.Model;

public class SessionModel implements Model {
	SessionModel	session	= new SessionModel();
	
	@Override
	public List<Entity> index() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public Entity get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int index, Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Entity entidade) {
				
	}

	@Override
	public Entity delete(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
