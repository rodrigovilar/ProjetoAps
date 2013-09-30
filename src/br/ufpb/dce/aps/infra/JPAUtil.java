package br.ufpb.dce.aps.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public static JPAUtil jpaUtil = null;
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("aps_pu");

	private JPAUtil() {
		this.jpaUtil = new JPAUtil();
	}

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static JPAUtil getInstance() {
		if (jpaUtil == null)
			jpaUtil = new JPAUtil();
		return jpaUtil;
	}
}