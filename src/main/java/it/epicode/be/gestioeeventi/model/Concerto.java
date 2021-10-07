package it.epicode.be.gestioeeventi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "concertiInStreaming", query = "select c from Concerto c where c.inStreaming = :streaming")
@NamedQuery(name = "concertiPerGenere", query = "select c from Concerto c where c.genere in :listagenere")
public class Concerto extends Evento {
	
	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;
	
	private Boolean inStreaming;

	public Concerto () {}

	

	public Concerto(Long id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location) {
		super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
	}



	public Boolean getInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	public GenereConcerto getGenere() {
		return genere;
	}

	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}
	
	

}
