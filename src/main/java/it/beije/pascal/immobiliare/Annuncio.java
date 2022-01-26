package it.beije.pascal.immobiliare;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.beije.pascal.immobiliareenums.AriaCondizionata;
import it.beije.pascal.immobiliareenums.Arredamento;
import it.beije.pascal.immobiliareenums.ClasseEnergetica;
import it.beije.pascal.immobiliareenums.Condizione;
import it.beije.pascal.immobiliareenums.Giardino;
import it.beije.pascal.immobiliareenums.Riscaldamento;
import it.beije.pascal.immobiliareenums.StatoRogito;
import it.beije.pascal.immobiliareenums.TipoAnnuncio;
import it.beije.pascal.immobiliareenums.TipoImmobile;



@Entity
@Table(name = "annuncio")
public class Annuncio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "tipo_immobile")
	private TipoImmobile tipoImmobile;
	@Column(name = "tipo_annuncio")
	private TipoAnnuncio tipoAnnuncio;
	private int prezzo;
	private int mq;
	private int locali;
	private int bagni;
	@Column(name = "tot_piani")
	private int totPiani;
	private int piano;
	private boolean ascensore;
	@Column(name = "posti_auto")
	private int postiAuto;
	private boolean balcone;
	private boolean terrazzo;
	private Giardino giardino;
	private Condizione condizione;
	@Column(name = "classe_energetica")
	private ClasseEnergetica classeEnergetica;
	private Riscaldamento riscaldamento;
	@Column(name = "aria_condizionata")
	private AriaCondizionata ariaCondizionata;
	private Arredamento arredamento;
	private boolean piscina;
	private boolean portineria;
	private int anno_costruzione;
	@Column(name = "stato_rogito")
	private StatoRogito statoRogito;
	@Column(name = "visita_guidata")
	private boolean visitaGuidata;
	@Column(name = "descrizione_lunga")
	private String descrizioneLunga;
	@Column(name = "virtual_tour")
	private boolean virtualTour;

	
	
	
	
}
