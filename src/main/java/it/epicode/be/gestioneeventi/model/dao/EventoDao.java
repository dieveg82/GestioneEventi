package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioeeventi.model.Evento;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class EventoDao {

	public void save(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(e);
		tranasction.commit();

		em.close();
	}

	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Evento e = em.find(Evento.class, id);
			return e;
		} finally {
			em.close();
		}
	}

	public void delete(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(e);
		} finally {
			em.close();
		}
	}

	public void refresh(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(e);
		} finally {
			em.close();
		}
	}
}