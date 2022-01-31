package it.beije.pascal.domus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "annunci_salvati")
public class AnnunciSalvati {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "annuncio_id")
	private int annuncioId;
	@Column(name = "utente_id")
	private int utenteid;
	private String commento;


	public int getId() {
		return annuncioId;
	}

	public void setId(int id) {
		this.annuncioId = id;
	}

	public int getUtenteid() {
		return utenteid;
	}

	public void setUtenteid(int utenteid) {
		this.utenteid = utenteid;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public AnnunciSalvati(int annuncioId, int utenteid, String commento) {
		super();
		this.annuncioId = annuncioId;
		this.utenteid = utenteid;
		this.commento = commento;
	}


	
	public AnnunciSalvati() {
		super();
	}


	
	
}
