package it.beije.pascal.domus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comune")
	private String comune;
	
	@Column(name="indirizzo")
	private String indirizzo;
	
	@Column(name="n_civico")
	private int nCivico;
	
	@Column(name="cap")
	private String cap;

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

	public int getnCivico() {
		return nCivico;
	}

	public void setnCivico(int nCivico) {
		this.nCivico = nCivico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", comune=" + comune + ", indirizzo=" + indirizzo + ", nCivico=" + nCivico
				+ ", cap=" + cap + "]";
	}

}
