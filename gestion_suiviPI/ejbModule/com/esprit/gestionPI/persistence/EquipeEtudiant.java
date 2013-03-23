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
	
	
   
}
