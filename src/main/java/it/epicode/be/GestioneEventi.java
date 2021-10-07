package it.epicode.be;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import it.epicode.be.gestioeeventi.model.Evento;
import it.epicode.be.gestioeeventi.model.GaraDiAtletica;
import it.epicode.be.gestioeeventi.model.Location;
import it.epicode.be.gestioeeventi.model.Partecipazioni;
import it.epicode.be.gestioeeventi.model.PartitaDiCalcio;
import it.epicode.be.gestioeeventi.model.Persona;
import it.epicode.be.gestioeeventi.model.Sesso;
import it.epicode.be.gestioeeventi.model.Stato;
import it.epicode.be.gestioeeventi.model.TipoEvento;
import it.epicode.be.gestioneeventi.model.dao.EventoDao;
import it.epicode.be.gestioneeventi.model.dao.GaraDiAtleticaDao;
import it.epicode.be.gestioneeventi.model.dao.LocationDao;
import it.epicode.be.gestioneeventi.model.dao.PartecipazioniDao;
import it.epicode.be.gestioneeventi.model.dao.PartitaDiCalcioDao;
import it.epicode.be.gestioneeventi.model.dao.PersonaDao;

public class GestioneEventi {

	public static void main(String[] args) {

		GestioneEventi gMain = new GestioneEventi ();
		gMain.eseguiTest ();
		
	}

	private void eseguiTest() {
	
		Location l1 = new Location(null,"Stadio","Milano");
		LocationDao ldao = new LocationDao();
		ldao.save(l1);
		Evento e1 = new Evento(null, "partita", new Date (), "italia vs spagna", TipoEvento.PUBBLICO, 100);
		e1.setLocation(l1);
		EventoDao edao = new EventoDao();
		edao.save(e1);

		Location l2 = new Location(null,"Stadio","Milano");
		ldao.save(l2);
		Evento e2 = new Evento(null, "partita", new Date (), "italia vs germania", TipoEvento.PUBBLICO, 100);
		e2.setLocation(l2);
		edao.save(e2);
		
		Location l3 = new Location(null,"Stadio","Milano");
		ldao.save(l3);
		Evento e3 = new Evento(null, "partita", new Date (), "italia vs svizzera", TipoEvento.PUBBLICO, 100);
		e3.setLocation(l3);
		edao.save(e3);
		
		
		PartitaDiCalcio p1 = new PartitaDiCalcio(null, e1.getTitolo(), e1.getDataEvento(),e1.getDescrizione() ,e1.getTipoEvento(), e1.getNumeroMassimoPartecipanti() ,"italia", "spagna", "null", 0, 0);
		PartitaDiCalcio p2 = new PartitaDiCalcio(null, e2.getTitolo(), e2.getDataEvento(),e2.getDescrizione() ,e2.getTipoEvento(), e2.getNumeroMassimoPartecipanti() ,"italia", "germania", "italia", 2, 1);
		PartitaDiCalcio p3 = new PartitaDiCalcio(null, e3.getTitolo(), e3.getDataEvento(),e3.getDescrizione() ,e3.getTipoEvento(), e3.getNumeroMassimoPartecipanti() ,"italia", "svizzera", "svizzera", 1, 2);

		PartitaDiCalcioDao pDao = new PartitaDiCalcioDao();	
		pDao.save(p1);
		pDao.save(p2);
		pDao.save(p3);
	
		Persona per1 = new Persona(null, "diego", "cappai", "diego.cappai@tiscali.it",new GregorianCalendar(1982,03, 12).getTime(), Sesso.MASCHIO);
		PersonaDao p1Dao = new PersonaDao();
		p1Dao.save(per1);
		
		Persona per2 = new Persona(null, "mario", "are", "mario.are@tiscali.it",new GregorianCalendar(1978,07, 15).getTime(), Sesso.MASCHIO);
		p1Dao.save(per2);
		
		Location l4 = new Location(null,"Stadio","Roma");
		ldao.save(l4);
		Evento e4 = new Evento(null, "gara Atletia", new Date (), "100 metri", TipoEvento.PUBBLICO, 50);
		e4.setLocation(l4);
		edao.save(e4);
		Partecipazioni par1Partecipazioni = new Partecipazioni(null, per1, e4, Stato.CONFERMATA);
		PartecipazioniDao parDao = new PartecipazioniDao ();
		parDao.save(par1Partecipazioni);
		Partecipazioni par2Partecipazioni = new Partecipazioni(null, per2, e4, Stato.CONFERMATA);
		parDao.save(par2Partecipazioni);
		
		
		
		GaraDiAtletica gara1 = new GaraDiAtletica(null, e4.getTitolo(), e4.getDataEvento(), e4.getDescrizione(), TipoEvento.PRIVATO, 50);
		gara1.setVincitore(per1);
		Set<Persona> setPersona = new HashSet<>();
		setPersona.add(per1);
		setPersona.add(per2);
		gara1.setSetAtleti(setPersona);
		GaraDiAtleticaDao gaDao = new GaraDiAtleticaDao();
		gaDao.save(gara1);
		
		
//		pDao.getPartiteVinteInCasalectAll();
//		pDao.getPartiteVinteInTrasferta();
//		pDao.getPartitePareggiate();
	}
}
