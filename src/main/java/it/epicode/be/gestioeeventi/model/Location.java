package it.epicode.be.gestioeeventi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table (name ="Location")
public class Location {

	@Id 
	@Column
	@SequenceGenerator (name ="be_location_sq" , sequenceName = "db_location_sq" , allocationSize = 1 )
	@GeneratedValue (strategy = GenerationType.SEQUENCE , generator = "be_location_sq")
	private Long id;
	@Column
	private String nome;
	@Column
	private String citta;

	
	public Location () {}

	public Location(Long id, String nome, String citta) {
		this.id = id;
		this.nome = nome;
		this.citta = citta;
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

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}
	
	
	
}
