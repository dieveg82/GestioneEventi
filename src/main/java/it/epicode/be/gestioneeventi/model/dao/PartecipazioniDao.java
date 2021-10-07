package it.epicode.be.gestioneeventi.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioeeventi.model.Partecipazioni;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class PartecipazioniDao {

	public void save(Partecipazioni p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(p);
		tranasction.commit();

		em.close();
	}
	
	public Partecipazioni getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Partecipazioni p = em.find(Partecipazioni.class, id);
			return p;
		} finally {
			em.close();
		}
	}

	public void delete(Partecipazioni p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(p);
		} finally {
			em.close();
		}
	}

	public void refresh(Partecipazioni p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(p);
		} finally {
			em.close();
		}
	}
	
	public List selectAll () {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Partecipazioni> listPart = new ArrayList<>();
		try {
		Query query = em.createQuery("select p from Partecipazioni p");
		listPart = query.getResultList();
		} finally {em.close();}
		return listPart;	
	}
}
