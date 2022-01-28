package it.beije.pascal.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String comune;
	private String indirizzo;
	private String cap;
	
	@Column(name = "n_civico")
	private int nCivico;
	
	@OneToMany
	@JoinColumn(name="indirizzo_id", referencedColumnName = "id")
	private List<Commerciale> commerciali;
	
	@OneToMany
	@JoinColumn(name="indirizzo_id", referencedColumnName = "id")
	private List<Annuncio> annunci;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public int getNCivico() {
		return nCivico;
	}

	public void setNCivico(int nCivico) {
		this.nCivico = nCivico;
	}

	public List<Commerciale> getCommerciali() {
		return commerciali;
	}

	public void setCommerciali(List<Commerciale> commerciali) {
		this.commerciali = commerciali;
	}

	public List<Annuncio> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(List<Annuncio> annunci) {
		this.annunci = annunci;
	}
	

}
