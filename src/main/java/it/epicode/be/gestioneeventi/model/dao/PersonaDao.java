package it.epicode.be.gestioneeventi.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.epicode.be.gestioeeventi.model.Persona;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class PersonaDao {

	
	public void save(Persona p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(p);
		tranasction.commit();

		em.close();
	}
	
	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Persona p = em.find(Persona.class, id);
			return p;
		} finally {
			em.close();
		}
	}

	public void delete(Persona p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(p);
		} finally {
			em.close();
		}
	}

	public void refresh(Persona p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(p);
		} finally {
			em.close();
		}
	}
}
