package com.esprit.gestionPI.persistence;

import java.io.Serializable;
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
 * Entity implementation class for Entity: EquipeEtudiant
 *
 */
@Entity

public class EquipeEtudiant implements Serializable {

	   
	
	private int IdEquipe;
	private String intitule;
	
	private Projet projet;
	
	private Enseignant enseignant;
	
	private Set<Etudiant> etudiants;
	
	private Set<FicheEquipe> fichesEquipes;
	private static final long serialVersionUID = 1L;

	public EquipeEtudiant() {
		super();
		etudiants=new HashSet<Etudiant>();
		fichesEquipes=new HashSet<FicheEquipe>();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdEquipe() {
		return this.IdEquipe;
	}

	public void setIdEquipe(int IdEquipe) {
		this.IdEquipe = IdEquipe;
	}   
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	@ManyToOne
	@JoinColumn(name="idProjet",referencedColumnName="idProjet")
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	@ManyToOne
	@JoinColumn(name="idEnseiganat")
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	@OneToMany(mappedBy="equipeEtudiant")
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	@OneToMany(mappedBy="ficheEquipe")
	public Set<FicheEquipe> getFichesEquipes() {
		return fichesEquipes;
	}
	public void setFichesEquipes(Set<FicheEquipe> fichesEquipes) {
		this.fichesEquipes = fichesEquipes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdEquipe;
		result = prime * result
				+ ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result
				+ ((etudiants == null) ? 0 : etudiants.hashCode());
		result = prime * result
				+ ((fichesEquipes == null) ? 0 : fichesEquipes.hashCode());
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
		EquipeEtudiant other = (EquipeEtudiant) obj;
		if (IdEquipe != other.IdEquipe)
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (etudiants == null) {
			if (other.etudiants != null)
				return false;
		} else if (!etudiants.equals(other.etudiants))
			return false;
		if (fichesEquipes == null) {
			if (other.fichesEquipes != null)
				return false;
		} else if (!fichesEquipes.equals(other.fichesEquipes))
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
		return "EquipeEtudiant [IdEquipe=" + IdEquipe + ", intitule="
				+ intitule + ", projet=" + projet + ", enseignant="
				+ enseignant + ", etudiants=" + etudiants + ", fichesEquipes="
				+ fichesEquipes + "]";
	}
	
	
   
}
