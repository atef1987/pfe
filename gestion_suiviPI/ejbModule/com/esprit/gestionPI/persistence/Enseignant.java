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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((equipeProjet == null) ? 0 : equipeProjet.hashCode());
		result = prime
				* result
				+ ((equipesEtudiants == null) ? 0 : equipesEtudiants.hashCode());
		result = prime * result + ((fiches == null) ? 0 : fiches.hashCode());
		result = prime * result + ((id_ens == null) ? 0 : id_ens.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((projets == null) ? 0 : projets.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result
				+ ((type_ens == null) ? 0 : type_ens.hashCode());
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
		Enseignant other = (Enseignant) obj;
		if (equipeProjet == null) {
			if (other.equipeProjet != null)
				return false;
		} else if (!equipeProjet.equals(other.equipeProjet))
			return false;
		if (equipesEtudiants == null) {
			if (other.equipesEtudiants != null)
				return false;
		} else if (!equipesEtudiants.equals(other.equipesEtudiants))
			return false;
		if (fiches == null) {
			if (other.fiches != null)
				return false;
		} else if (!fiches.equals(other.fiches))
			return false;
		if (id_ens == null) {
			if (other.id_ens != null)
				return false;
		} else if (!id_ens.equals(other.id_ens))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (projets == null) {
			if (other.projets != null)
				return false;
		} else if (!projets.equals(other.projets))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (type_ens == null) {
			if (other.type_ens != null)
				return false;
		} else if (!type_ens.equals(other.type_ens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enseignant [id_ens=" + id_ens + ", nom=" + nom + ", prenom="
				+ prenom + ", type_ens=" + type_ens + ", equipeProjet="
				+ equipeProjet + ", fiches=" + fiches + ", role=" + role
				+ ", projets=" + projets + ", equipesEtudiants="
				+ equipesEtudiants + "]";
	}




}
