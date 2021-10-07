package it.epicode.be.gestioeeventi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "getPartiteVinteInCasa", query = "select c from PartitaDiCalcio c where c.squadraVincente =c.squadraDiCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "select c from PartitaDiCalcio c where c.squadraVincente =c.squadraOspite")
@NamedQuery(name = "getPartitePareggiate", query = "select c from PartitaDiCalcio c where c.squadraVincente is null")   // prof non riesco a capire perchè non mi funziona questa query

public class PartitaDiCalcio extends Evento {
	
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private Integer numGolCasa = 0;
	private Integer numGolOspite = 0;
	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}
	
	public PartitaDiCalcio () {}
	
	
	public PartitaDiCalcio(Long id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti ,String squadraDiCasa, String squadraOspite, String squadraVincente, 
			Integer numGolCasa,Integer numGolOspite) {
		super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.numGolCasa = numGolCasa;
		this.numGolOspite = numGolOspite;
	}


	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}
	public String getSquadraOspite() {
		return squadraOspite;
	}
	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}
	public String getSquadraVincente() {
		return squadraVincente;
	}
	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}
	public Integer getNumGolCasa() {
		return numGolCasa;
	}
	public void setNumGolCasa(Integer numGolCasa) {
		this.numGolCasa = numGolCasa;
	}
	public Integer getNumGolOspite() {
		return numGolOspite;
	}
	public void setNumGolOspite(Integer numGolOspite) {
		this.numGolOspite = numGolOspite;
	}
	
	

}
