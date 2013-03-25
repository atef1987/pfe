package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Critere
 *
 */
@Entity

public class Critere implements Serializable {

	   
	
	private int idCritere;
	private String libelle;
	private Float noteCritere;
	private Set<ModelFiche> modelFiches;
	private static final long serialVersionUID = 1L;

	public Critere() {
		super();
		modelFiches= new HashSet<ModelFiche>();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdCritere() {
		return this.idCritere;
	}

	public void setIdCritere(int idCritere) {
		this.idCritere = idCritere;
	}   
	public Critere(int idCritere, String libelle, Float noteCritere) {
		super();
		this.idCritere = idCritere;
		this.libelle = libelle;
		this.noteCritere = noteCritere;
	}
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Float getNoteCritere() {
		return noteCritere;
	}
	public void setNoteCritere(Float noteCritere) {
		this.noteCritere = noteCritere;
	}
	
	@ManyToMany(mappedBy="criteres")
	public Set<ModelFiche> getModelFiches() {
		return modelFiches;
	}
	public void setModelFiches(Set<ModelFiche> modelFiches) {
		this.modelFiches = modelFiches;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCritere;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result
				+ ((modelFiches == null) ? 0 : modelFiches.hashCode());
		result = prime * result
				+ ((noteCritere == null) ? 0 : noteCritere.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Critere other = (Critere) obj;
		if (idCritere != other.idCritere)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (modelFiches == null) {
			if (other.modelFiches != null)
				return false;
		} else if (!modelFiches.equals(other.modelFiches))
			return false;
		if (noteCritere == null) {
			if (other.noteCritere != null)
				return false;
		} else if (!noteCritere.equals(other.noteCritere))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Critere [idCritere=" + idCritere + ", libelle=" + libelle
				+ ", noteCritere=" + noteCritere + ", modelFiches="
				+ modelFiches + "]";
	}
	
	
	
	
   
}
