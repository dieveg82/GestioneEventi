package it.epicode.be.gestioeeventi.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import it.epicode.be.gestioneeventi.util.JpaUtil;

@Entity 
@Table (name = "Partecipazioni")
@NamedQuery (name = "selectAll" , query = "select p from Partecipazioni p ")
public class Partecipazioni {
	
	@Id 
	@Column
	@SequenceGenerator (name = "be_partecipazioni_sq" , sequenceName = "db_partecipazioni_sq" , allocationSize = 1 )
	@GeneratedValue (strategy = GenerationType.SEQUENCE , generator = "be_partecipazioni_sq")
	private Long id;
	@ManyToOne
	private Persona persPart;
	@ManyToOne
	private Evento evenPart;
	@Column 
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	public Partecipazioni () {}
	
	

	public Partecipazioni(Long id, Persona persPart, Evento evenPart, Stato stato) {
		this.id = id;
		this.persPart = persPart;
		this.evenPart = evenPart;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersPart() {
		return persPart;
	}

	public void setPersPart(Persona persPart) {
		this.persPart = persPart;
	}

	public Evento getEvenPart() {
		return evenPart;
	}

	public void setEvenPart(Evento evenPart) {
		this.evenPart = evenPart;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazioni [id=" + id + ", persPart=" + persPart + ", evenPart=" + evenPart + ", stato=" + stato
				+ "]";
	}
	
	public List selectAll () {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("selectAll");
			List<Partecipazioni> resultList = (List<Partecipazioni>) query.getResultList();
			for (Partecipazioni e1 : resultList) {
				System.out.println(e1);
				return resultList;
				
			}
		} finally {
			em.close();
		}
		return null;
	}
		
}
