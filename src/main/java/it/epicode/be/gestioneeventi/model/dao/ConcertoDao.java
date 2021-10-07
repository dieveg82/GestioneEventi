package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioeeventi.model.Concerto;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class ConcertoDao {

	public void save(Concerto e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(e);
		tranasction.commit();

		em.close();
	}

	public Concerto getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Concerto e = em.find(Concerto.class, id);
			return e;
		} finally {
			em.close();
		}
	}

	public void delete(Concerto e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(e);
		} finally {
			em.close();
		}
	}

	public void refresh(Concerto e) {
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
			List<Concerto> resultList = query.getResultList();
			for (Concerto e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
}
