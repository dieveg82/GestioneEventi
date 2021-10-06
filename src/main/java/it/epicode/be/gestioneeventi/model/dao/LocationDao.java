package it.epicode.be.gestioneeventi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.epicode.be.gestioeeventi.model.Evento;
import it.epicode.be.gestioeeventi.model.Location;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class LocationDao {

	public void save(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(l);
		tranasction.commit();

		em.close();
	}
	
	public Location getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Location l = em.find(Location.class, id);
			return l;
		} finally {
			em.close();
		}
	}

	public void delete(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(l);
		} finally {
			em.close();
		}
	}

	public void refresh(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(l);
		} finally {
			em.close();
		}
	}
	
}
