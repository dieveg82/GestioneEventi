package it.epicode.be.gestioeeventi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona {

	@Id
	@Column
	@SequenceGenerator(name = "be_persona_sq", sequenceName = "db_persona_sq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "be_persona_sq")
	private Long id;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private String mail;
	@Column
	private Date dataDiNascita;
	@Column
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy = "persPart" , cascade = CascadeType.REMOVE)
	@OrderBy("Evento.dataEvento")
	private List<Partecipazioni> listPart = new ArrayList<>();

	public Persona() {
	}

	public Persona(Long id, String nome, String cognome, String mail ,Date dataDiNascita, Sesso sesso) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazioni> getListPart() {
		return listPart;
	}

	public void setListPart(List<Partecipazioni> listPart) {
		this.listPart = listPart;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", sesso=" + sesso + "]";
	}

}
