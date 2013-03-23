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

}
