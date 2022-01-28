package it.beije.pascal.domus;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.beije.pascal.domus.enums.AriaCondizionata;
import it.beije.pascal.domus.enums.Arredamento;
import it.beije.pascal.domus.enums.ClasseEnergetica;
import it.beije.pascal.domus.enums.Condizione;
import it.beije.pascal.domus.enums.Giardino;
import it.beije.pascal.domus.enums.Riscaldamento;
import it.beije.pascal.domus.enums.StatoRogito;
import it.beije.pascal.domus.enums.TipoAnnuncio;
import it.beije.pascal.domus.enums.TipoImmobile;

@Entity
@Table(name = "annuncio")
public class Annuncio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "venditore_id")
	private Integer venditoreId;
	@Column(name = "piantina_id")
	private Integer piantinaId;
	@Column(name = "indirizzo_id")
	private Integer indirizzoId;
	@Column(name = "edificio_id")
	private Integer edificioId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_immobile")
	private TipoImmobile tipoImmobile;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_annuncio")
	private TipoAnnuncio tipoAnnuncio;
	private Integer prezzo;
	private Integer mq;
	private Integer locali;
	private Integer bagni;
	@Column(name = "tot_piani")
	private Integer totPiani;
	private Integer piano;
	private boolean ascensore;
	@Column(name = "posti_auto")
	private Integer postiAuto;
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
	private Integer anno_costruzione;
	@Enumerated(EnumType.STRING)
	@Column(name = "stato_rogito")
	private StatoRogito statoRogito;
	@Column(name = "visita_guidata")
	private boolean visitaGuidata;
	@Column(name = "descrizione_lunga")
	private String descrizioneLunga;
	@Column(name = "virtual_tour")
	private boolean virtualTour;
//	@Column(name = "create_timestamp")
//	private Timestamp createTimestamp;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVenditoriId() {
		return venditoreId;
	}
	public void setVenditoriId(Integer venditoriId) {
		this.venditoreId = venditoriId;
	}

	public Integer getPiantinaId() {
		return piantinaId;
	}
	public void setPiantinaId(Integer piantinaId) {
		this.piantinaId = piantinaId;
	}
	public Integer getIndirizzoId() {
		return indirizzoId;
	}
	public void setIndirizzoId(Integer indirizzoId) {
		this.indirizzoId = indirizzoId;
	}
	public Integer getEdificioId() {
		return edificioId;
	}
	public void setEdificioId(Integer edificioId) {
		this.edificioId = edificioId;
	}
	public TipoImmobile getTipoImmobile() {
		return tipoImmobile;
	}
	public void setTipoImmobile(TipoImmobile tipoImmobile) {
		this.tipoImmobile = tipoImmobile;
	}
	public TipoAnnuncio getTipoAnnuncio() {
		return tipoAnnuncio;
	}
	public void setTipoAnnuncio(TipoAnnuncio tipoAnnuncio) {
		this.tipoAnnuncio = tipoAnnuncio;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getMq() {
		return mq;
	}
	public void setMq(Integer mq) {
		this.mq = mq;
	}
	public Integer getLocali() {
		return locali;
	}
	public void setLocali(Integer locali) {
		this.locali = locali;
	}
	public Integer getBagni() {
		return bagni;
	}
	public void setBagni(Integer bagni) {
		this.bagni = bagni;
	}
	public Integer getTotPiani() {
		return totPiani;
	}
	public void setTotPiani(Integer totPiani) {
		this.totPiani = totPiani;
	}
	public Integer getPiano() {
		return piano;
	}
	public void setPiano(Integer piano) {
		this.piano = piano;
	}
	public boolean isAscensore() {
		return ascensore;
	}
	public void setAscensore(boolean ascensore) {
		this.ascensore = ascensore;
	}
	public Integer getPostiAuto() {
		return postiAuto;
	}
	public void setPostiAuto(Integer postiAuto) {
		this.postiAuto = postiAuto;
	}
	public boolean isBalcone() {
		return balcone;
	}
	public void setBalcone(boolean balcone) {
		this.balcone = balcone;
	}
	public boolean isTerrazzo() {
		return terrazzo;
	}
	public void setTerrazzo(boolean terrazzo) {
		this.terrazzo = terrazzo;
	}
	public Giardino getGiardino() {
		return giardino;
	}
	public void setGiardino(Giardino giardino) {
		this.giardino = giardino;
	}
	public Condizione getCondizione() {
		return condizione;
	}
	public void setCondizione(Condizione condizione) {
		this.condizione = condizione;
	}
	public ClasseEnergetica getClasseEnergetica() {
		return classeEnergetica;
	}
	public void setClasseEnergetica(ClasseEnergetica classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}
	public Riscaldamento getRiscaldamento() {
		return riscaldamento;
	}
	public void setRiscaldamento(Riscaldamento riscaldamento) {
		this.riscaldamento = riscaldamento;
	}
	public AriaCondizionata getAriaCondizionata() {
		return ariaCondizionata;
	}
	public void setAriaCondizionata(AriaCondizionata ariaCondizionata) {
		this.ariaCondizionata = ariaCondizionata;
	}
	public Arredamento getArredamento() {
		return arredamento;
	}
	public void setArredamento(Arredamento arredamento) {
		this.arredamento = arredamento;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isPortineria() {
		return portineria;
	}
	public void setPortineria(boolean portineria) {
		this.portineria = portineria;
	}
	public Integer getAnno_costruzione() {
		return anno_costruzione;
	}
	public void setAnno_costruzione(Integer anno_costruzione) {
		this.anno_costruzione = anno_costruzione;
	}
	public StatoRogito getStatoRogito() {
		return statoRogito;
	}
	public void setStatoRogito(StatoRogito statoRogito) {
		this.statoRogito = statoRogito;
	}
	public boolean isVisitaGuidata() {
		return visitaGuidata;
	}
	public void setVisitaGuidata(boolean visitaGuidata) {
		this.visitaGuidata = visitaGuidata;
	}
	public String getDescrizioneLunga() {
		return descrizioneLunga;
	}
	public void setDescrizioneLunga(String descrizioneLunga) {
		this.descrizioneLunga = descrizioneLunga;
	}
	public boolean isVirtualTour() {
		return virtualTour;
	}
	public void setVirtualTour(boolean virtualTour) {
		this.virtualTour = virtualTour;
	}
//	public Timestamp getCreateTimestamp() {
//		return createTimestamp;
//	}
//	public void setCreateTimestamp(Timestamp createTimestamp) {
//		this.createTimestamp = createTimestamp;
//	}
	@Override
	public String toString() {
		return "Annuncio [id=" + id + ", venditoreId=" + venditoreId + ", piantinaId=" + piantinaId + ", indirizzoId="
				+ indirizzoId + ", edificioId=" + edificioId + ", "
				+ (tipoImmobile != null ? "tipoImmobile=" + tipoImmobile + ", " : "")
				+ (tipoAnnuncio != null ? "tipoAnnuncio=" + tipoAnnuncio + ", " : "") + "prezzo=" + prezzo + ", mq="
				+ mq + ", locali=" + locali + ", bagni=" + bagni + ", totPiani=" + totPiani + ", piano=" + piano
				+ ", ascensore=" + ascensore + ", postiAuto=" + postiAuto + ", balcone=" + balcone + ", terrazzo="
				+ terrazzo + ", " + (giardino != null ? "giardino=" + giardino + ", " : "")
				+ (condizione != null ? "condizione=" + condizione + ", " : "")
				+ (classeEnergetica != null ? "classeEnergetica=" + classeEnergetica + ", " : "")
				+ (riscaldamento != null ? "riscaldamento=" + riscaldamento + ", " : "")
				+ (ariaCondizionata != null ? "ariaCondizionata=" + ariaCondizionata + ", " : "")
				+ (arredamento != null ? "arredamento=" + arredamento + ", " : "") + "piscina=" + piscina
				+ ", portineria=" + portineria + ", anno_costruzione=" + anno_costruzione + ", "
				+ (statoRogito != null ? "statoRogito=" + statoRogito + ", " : "") + "visitaGuidata=" + visitaGuidata
				+ ", " + (descrizioneLunga != null ? "descrizioneLunga=" + descrizioneLunga + ", " : "")
				+ "virtualTour=" + virtualTour + "]";
	}
	
	

	
	
	
	
}