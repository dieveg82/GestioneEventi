package it.epicode.be.gestioneeventi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.epicode.be.gestioeeventi.model.PartitaDiCalcio;
import it.epicode.be.gestioneeventi.util.JpaUtil;

public class PartitaDiCalcioDao {

	public void save(PartitaDiCalcio e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		EntityTransaction tranasction = em.getTransaction();
		tranasction.begin();
		em.persist(e);
		tranasction.commit();

		em.close();
	}

	public PartitaDiCalcio getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			PartitaDiCalcio e = em.find(PartitaDiCalcio.class, id);
			return e;
		} finally {
			em.close();
		}
	}

	public void delete(PartitaDiCalcio e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.remove(e);
		} finally {
			em.close();
		}
	}

	public void refresh(PartitaDiCalcio e) {
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
			List<PartitaDiCalcio> resultList = query.getResultList();
			for (PartitaDiCalcio e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
	
	public void getPartiteVinteInCasalectAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getPartiteVinteInCasa");
			List<PartitaDiCalcio> resultList = query.getResultList();
			System.out.println("---------------");
			System.out.println("-Vinte in casa-");
			System.out.println("---------------");
			for (PartitaDiCalcio e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
	
	public void getPartiteVinteInTrasferta() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getPartiteVinteInTrasferta");
			List<PartitaDiCalcio> resultList = query.getResultList();
			System.out.println("--------------------");
			System.out.println("-Vinte in trasferta-");
			System.out.println("--------------------");
			for (PartitaDiCalcio e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
	
	public void getPartitePareggiate() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getPartitePareggiate");
			List<PartitaDiCalcio> resultList = query.getResultList();
			System.out.println("--------------------");
			System.out.println("-Partita Pareggiata-");
			System.out.println("--------------------");
			for (PartitaDiCalcio e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
}
