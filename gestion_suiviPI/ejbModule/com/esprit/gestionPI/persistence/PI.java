package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PI
 *
 */
@Entity

public class PI implements Serializable {

	   
	
	private int idPI;
	private String intitule;
	private String description;
	private static final long serialVersionUID = 1L;

	public PI() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPI() {
		return this.idPI;
	}

	public void setIdPI(int idPI) {
		this.idPI = idPI;
	}   
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
