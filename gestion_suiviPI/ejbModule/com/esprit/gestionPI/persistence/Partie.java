package com.esprit.gestionPI.persistence;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Partie
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("partie")

public class Partie implements Serializable {

	   

	protected int IdPartie;
	protected String intitule;
	protected String description;
	
	private Projet projet;
	
	private Fiche fiche;
	protected static final long serialVersionUID = 1L;

	public Partie() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPartie() {
		return this.IdPartie;
	}

	public void setIdPartie(int IdPartie) {
		this.IdPartie = IdPartie;
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
	
	@ManyToOne
	@JoinColumn(name="idProjet",referencedColumnName="idProjet")
	public Projet getProjet() {
		return projet;
	}
	
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	@OneToOne
	@JoinColumn(name="idFiche", unique=true)
	public Fiche getFiche() {
		return fiche;
	}
	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdPartie;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fiche == null) ? 0 : fiche.hashCode());
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((projet == null) ? 0 : projet.hashCode());
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
		Partie other = (Partie) obj;
		if (IdPartie != other.IdPartie)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fiche == null) {
			if (other.fiche != null)
				return false;
		} else if (!fiche.equals(other.fiche))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (projet == null) {
			if (other.projet != null)
				return false;
		} else if (!projet.equals(other.projet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partie [IdPartie=" + IdPartie + ", intitule=" + intitule
				+ ", description=" + description + ", projet=" + projet
				+ ", fiche=" + fiche + "]";
	}
	
	
	
	
   
}
