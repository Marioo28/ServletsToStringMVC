package com.fdm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="piese")
public class Piesa {

	@Id
	private int id;
	private String nume;
	private String categorie;
	private int stoc;
	
	public Piesa() {
		
	}

	public Piesa(int id, String nume, String categorie, int stoc) {
		this.id = id;
		this.nume = nume;
		this.categorie = categorie;
		this.stoc = stoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getStoc() {
		return stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

}
