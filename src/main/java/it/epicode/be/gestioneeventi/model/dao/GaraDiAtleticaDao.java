package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioeeventi.model.GaraDiAtletica;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class GaraDiAtleticaDao {

	public void save(GaraDiAtletica e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(e);
		tranasction.commit();

		em.close();
	}

	public GaraDiAtletica getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			GaraDiAtletica e = em.find(GaraDiAtletica.class, id);
			return e;
		} finally {
			em.close();
		}
	}

	public void delete(GaraDiAtletica e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(e);
		} finally {
			em.close();
		}
	}

	public void refresh(GaraDiAtletica e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(e);
		} finally {
			em.close();
		}
	}
	
	public void selectAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getAll");
			List<GaraDiAtletica> resultList = query.getResultList();
			for (GaraDiAtletica e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
}
