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
 * Entity implementation class for Entity: Etudiant
 * 
 */
@Entity
public class Etudiant implements Serializable {
	
	private String ID_ET;
	private String nom_ET;
	private String prenom_ET;
	
	private Classe classe;
	
	private Set<FicheEtudiant> fichesEtudiant;
	
	private EquipeEtudiant equipeEtudiant;
	
	private Set<Reponse> reponses;
	

	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
		fichesEtudiant = new HashSet<FicheEtudiant>();
		reponses=new HashSet<Reponse>();

	}

	@Id
	public String getID_ET() {
		return ID_ET;
	}

	public void setID_ET(String iD_ET) {
		ID_ET = iD_ET;
	}

	public String getNom_ET() {
		return nom_ET;
	}

	public void setNom_ET(String nom_ET) {
		this.nom_ET = nom_ET;
	}

	public String getPrenom_ET() {
		return prenom_ET;
	}

	public void setPrenom_ET(String prenom_ET) {
		this.prenom_ET = prenom_ET;
	}

	@ManyToOne
	@JoinColumn(name = "idClasse")
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	@ManyToOne
	@JoinColumn(name="idEuipeEtudiant")
	public EquipeEtudiant getEquipeEtudiant() {
		return equipeEtudiant;
	}

	public void setEquipeEtudiant(EquipeEtudiant equipeEtudiant) {
		this.equipeEtudiant = equipeEtudiant;
	}

	@OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Set<Reponse> reponses) {
		this.reponses = reponses;
	}

	@OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<FicheEtudiant> getFichesEtudiant() {
		return fichesEtudiant;
	}

	public void setFichesEtudiant(Set<FicheEtudiant> fichesEtudiant) {
		this.fichesEtudiant = fichesEtudiant;
	}
	
	
	
	

}
