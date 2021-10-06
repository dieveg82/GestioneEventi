package it.epicode.be.gestioeeventi.model;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.epicode.be.gestioneeventi.util.JpaUtil;

@Entity
@Table(name = "Evento")
@NamedQuery(name ="getAll" , query ="select e from Evento e")
@NamedQuery(name ="getPubblici" , query ="select e from Evento e where e.tipoEvento like : tipoEvento")

public class Evento {

	@Id
	@Column
	@SequenceGenerator(name = "be_evento_sq", sequenceName = "db_evento_sq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "be_evento_sq")
	private Long id;
	@Column
	private String titolo;
	@Column
	private Date dataEvento;
	@Column
	private String descrizione;
	@Column
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	@Column
	private Integer numeroMassimoPartecipanti;
	@OneToMany(mappedBy = "evenPart")
	private Set<Partecipazioni> setPartecipazioni = new HashSet<>();
	@OneToOne
	private Location location;

	public Evento() {
	}

	public Evento(Long id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		this.id = id;
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Evento(Long id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti) {
		this.id = id;
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Set<Partecipazioni> getSetPartecipazioni() {
		return setPartecipazioni;
	}

	public void setSetPartecipazioni(Set<Partecipazioni> setPartecipazioni) {
		this.setPartecipazioni = setPartecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}

	
	
	public void selectAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getAll");
			List<Evento> resultList = query.getResultList();
			for (Evento e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}
	
	public void selectPublic() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = em.createNamedQuery("getPubblici");
			query.setParameter("tipoEvento", "tipoEvento.PUBBLICO");
			List<Evento> resultList = query.getResultList();
			for (Evento e1 : resultList) {
				System.out.println(e1);
			}
		} finally {
			em.close();
		}
	}

}
