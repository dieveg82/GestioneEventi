package it.epicode.be.gestioeeventi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


//"SELECT c FROM Car c LEFT JOIN c.reservation r WHERE c.producer=:producer "
@Entity
//@NamedQuery(name ="getGareDiAtleticaPerVincitore" , query ="select e Persona e right join GaraAtletica a on e.id  :a.vincitore_id")
//select * from gestioneeventi.persona e  right join gestioneeventi.garadiatletica a on e.id  = a.vincitore_id  
// sinceramente non so come come scriverla in una NamedQuery 
//select * from gestioneeventi.persona e  left join gestioneeventi.garadiatletica a on e.id  = a.id
//anche questa sinceramente non so come scriverla
//@NamedQuery(name ="getGareDiAtleticaPerPartecipante" , query ="select e from Persona e.setAtleti")

public class GaraDiAtletica extends Evento {
		
	@ManyToMany
	private Set<Persona> setAtleti;
	
	@ManyToOne
	private Persona vincitore;
	
	public GaraDiAtletica () {}
	
	

	public GaraDiAtletica(Long id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location) {
		super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}
	
	

}
