package it.epicode.be;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import it.epicode.be.gestioeeventi.model.Evento;
import it.epicode.be.gestioeeventi.model.Location;
import it.epicode.be.gestioeeventi.model.Partecipazioni;
import it.epicode.be.gestioeeventi.model.Persona;
import it.epicode.be.gestioeeventi.model.Sesso;
import it.epicode.be.gestioeeventi.model.Stato;
import it.epicode.be.gestioeeventi.model.TipoEvento;
import it.epicode.be.gestioneeventi.model.dao.EventoDao;
import it.epicode.be.gestioneeventi.model.dao.LocationDao;
import it.epicode.be.gestioneeventi.model.dao.PartecipazioniDao;
import it.epicode.be.gestioneeventi.model.dao.PersonaDao;

public class GestioneEventi {

	public static void main(String[] args) {

		GestioneEventi gMain = new GestioneEventi ();
		gMain.eseguiTest ();
		
	}

	private void eseguiTest() {
	
//		Location l1 = new Location(null, "location1", "roma");
//		LocationDao ldao = new LocationDao ();
//		ldao.save(l1);
//		
//		// attenzione nella classe calendare il mese parte da 0 , ossia questo mese "9" è Ottobre
//		Persona p1 = new Persona(null, "marco", "rosa","marco.rosa@gmail.com", new GregorianCalendar(1980,9, 23).getTime(), Sesso.MASCHIO);
//		PersonaDao p1Dao = new PersonaDao();
//		p1Dao.save(p1);
//		
//		Evento e1 = new Evento(null,"evento2", new Date () , "prova descrizione2", TipoEvento.PUBBLICO, 1);
//		e1.setLocation(l1);
//		EventoDao eDao = new EventoDao();
//		eDao.save(e1);
//		
//		Partecipazioni par1 = new Partecipazioni(null, p1, e1, Stato.CONFERMATA);
//		PartecipazioniDao parDao = new PartecipazioniDao();
//		parDao.save(par1);
		EventoDao e = new EventoDao ();
		e.selectAll();
		e.selectPublic();
		Persona p = new Persona ();
		PartecipazioniDao parDao = new PartecipazioniDao();
		p.setListPart(parDao.selectAll());
		for (Partecipazioni pa : p.getListPart()) {
			System.out.println(pa);
		}
		
		
	}
}
