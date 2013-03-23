package com.esprit.gestionPI.persistence;

import java.io.Serializable;

/**
 * ID class for entity: Note
 *
 */ 
public class NotePK  implements Serializable {   
   
	         
	private int idFiche;         
	private int idCritere;
	private static final long serialVersionUID = 1L;

	public NotePK() {}

	public int getIdFiche() {
		return this.idFiche;
	}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}
	

	public int getIdCritere() {
		return this.idCritere;
	}

	public void setIdCritere(int idCritere) {
		this.idCritere = idCritere;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof NotePK)) {
			return false;
		}
		NotePK other = (NotePK) o;
		return true
			&& getIdFiche() == other.getIdFiche()
			&& getIdCritere() == other.getIdCritere();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getIdFiche();
		result = prime * result + getIdCritere();
		return result;
	}
   
   
}
