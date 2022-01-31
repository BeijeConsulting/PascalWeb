package it.beije.pascal.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Integer annuncio_id;
	private String url;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAnnuncio_id() {
		return annuncio_id;
	}
	public void setAnnuncio_id(Integer annuncio_id) {
		this.annuncio_id = annuncio_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
