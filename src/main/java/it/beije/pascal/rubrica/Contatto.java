package it.beije.pascal.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE TABLE `rubrica`.`contatti` (
`id` INT NOT NULL AUTO_INCREMENT,
`cognome` VARCHAR(45) NULL,
`nome` VARCHAR(45) NULL,
`telefono` VARCHAR(20) NULL,
`email` VARCHAR(100) NULL,
`note` VARCHAR(200) NULL,
PRIMARY KEY (`id`));
*/


@Entity
@Table(name = "contatti")
public class Contatto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "cognome")
	private String cognome;

	@Column(name = "nome")
	private String nome;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "email")
	private String email;
	
	@Column(name = "note")
	private String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Contatto() {
	}
	
	public Contatto(int id, String cognome, String nome, String telefono, String email, String note) {
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}
	public Contatto(String cognome, String nome, String telefono, String email, String note) {
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	
}
