package it.beije.pascal.bean;

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
	@Column(name = "annuncio_id")
	private int annuncioid;
	
	@Column(name = "utente_id")
	private int utenteid;
	
	private String commento;
	
	@Column(name = "avatar_url")
	private String avatarurl;


	public int getAnnuncioid() {
		return annuncioid;
	}

	public void setAnnuncioid(int annuncioid) {
		this.annuncioid = annuncioid;
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

	public String getAvatarurl() {
		return avatarurl;
	}

	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	

	
	
}
