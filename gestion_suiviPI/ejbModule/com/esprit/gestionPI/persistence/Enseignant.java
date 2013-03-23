package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Enseignant
 * 
 */
@Entity
public class Enseignant implements Serializable {

	private String id_ens;
	private String nom;
	private String prenom;
	private String type_ens;
	
	private EquipeProjet equipeProjet;
	
	private Set<Fiche> fiches;
	
	private Role role;
	private Set<Projet> projets;
	
	private Set<EquipeEtudiant> equipesEtudiants;
	
	

	private static final long serialVersionUID = 1L;

	public Enseignant() {
		super();
		fiches=new HashSet<Fiche>();
		projets=new HashSet<Projet>();
		equipesEtudiants=new HashSet<EquipeEtudiant>();
	}

	@Id
	
	public String getId_ens() {
		return id_ens;
	}

	public void setId_ens(String id_ens) {
		this.id_ens = id_ens;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType_ens() {
		return type_ens;
	}
	public void setType_ens(String type_ens) {
		this.type_ens = type_ens;
	}

	@ManyToOne
	@JoinColumn(name="idEquipeProjet",referencedColumnName="idEquipeProjet")
	public EquipeProjet getEquipeProjet() {
		return equipeProjet;
	}

	public void setEquipeProjet(EquipeProjet equipeProjet) {
		this.equipeProjet = equipeProjet;
	}

	@OneToMany(mappedBy="enseignant",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(Set<Fiche> fiches) {
		this.fiches = fiches;
	}

	@ManyToOne
	@JoinColumn(name="idRole")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(mappedBy="enseignant")
	public Set<EquipeEtudiant> getEquipesEtudiants() {
		return equipesEtudiants;
	}

	public void setEquipesEtudiants(Set<EquipeEtudiant> equipesEtudiants) {
		this.equipesEtudiants = equipesEtudiants;
	}

	@OneToMany(mappedBy="enseignant")
	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}




}
