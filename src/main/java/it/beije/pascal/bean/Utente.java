package it.beije.pascal.bean;

//import java.sql.Timestamp;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="avatar_url")
	private String avatarUrl;
	
	@Column(name="password")
	private String password;
	
	@Column(name="spam_check")
	private boolean spamCheck;
	
	@Column(name="amministratore")
	private boolean amministratore;

	@Column(name="username")
	private String username;
	
	@Column(name="commerciale_id")
	private Integer commercialeId;
	
//	@OneToMany
//	@JoinColumn(name="utente_id", referencedColumnName = "id")
//	private List<Ricerca> ricerche;
//
//	@ManyToMany
//	@JoinTable(
//	  name = "annunci_salvati",
//	  joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "id"),
//	  inverseJoinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "id")
//	)	
//	private List<Annuncio> annunciSalvati;

	
	public int getCommercialeId() {
		return commercialeId;
	}

	public void setCommercialeId(int commercialeId) {
		this.commercialeId = commercialeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSpamCheck() {
		return spamCheck;
	}

	public void setSpamCheck(boolean spamCheck) {
		this.spamCheck = spamCheck;
	}

	public boolean isAmministratore() {
		return amministratore;
	}

	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<Ricerca> getRicerche() {
//		return ricerche;
//	}
//
//	public void setRicerche(List<Ricerca> ricerche) {
//		this.ricerche = ricerche;
//	}
//
//	public List<Annuncio> getAnnunciSalvati() {
//		return annunciSalvati;
//	}
//
//	public void setAnnunciSalvati(List<Annuncio> annunciSalvati) {
//		this.annunciSalvati = annunciSalvati;
//	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", email=" + email + ", avatar_url=" + avatarUrl + ", password=" + password
				+ ", spam_check=" + spamCheck + ", amministratore=" + amministratore + ", username" + username + "]";
	}

	
}
