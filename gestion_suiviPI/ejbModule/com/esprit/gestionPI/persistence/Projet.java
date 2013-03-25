package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Projet
 * 
 */
@Entity
public class Projet implements Serializable {

	
	private int idProjet;
	private String intitule;
	private String description;
	private Date dateCreation;
	private Set<Partie> parties;	
	private Set<EquipeEtudiant> equipesEtudiants;
	
	private Enseignant enseignant;
	private static final long serialVersionUID = 1L;

	public Projet() {
		super();
		parties = new HashSet<Partie>();
		equipesEtudiants = new HashSet<EquipeEtudiant>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@OneToMany(mappedBy = "projet")
	public Set<Partie> getParties() {
		return parties;
	}

	public void setParties(Set<Partie> parties) {
		this.parties = parties;
	}

	@OneToMany(mappedBy = "projet")
	public Set<EquipeEtudiant> getEquipesEtudiants() {
		return equipesEtudiants;
	}

	public void setEquipesEtudiants(Set<EquipeEtudiant> equipesEtudiants) {
		this.equipesEtudiants = equipesEtudiants;
	}

	@ManyToOne
	@JoinColumn(name = "idEnseignant")
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime
				* result
				+ ((equipesEtudiants == null) ? 0 : equipesEtudiants.hashCode());
		result = prime * result + idProjet;
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((parties == null) ? 0 : parties.hashCode());
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
		Projet other = (Projet) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (equipesEtudiants == null) {
			if (other.equipesEtudiants != null)
				return false;
		} else if (!equipesEtudiants.equals(other.equipesEtudiants))
			return false;
		if (idProjet != other.idProjet)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (parties == null) {
			if (other.parties != null)
				return false;
		} else if (!parties.equals(other.parties))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", intitule=" + intitule
				+ ", description=" + description + ", dateCreation="
				+ dateCreation + ", parties=" + parties + ", equipesEtudiants="
				+ equipesEtudiants + ", enseignant=" + enseignant + "]";
	}

}
