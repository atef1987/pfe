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
 * Entity implementation class for Entity: EquipeProjet
 * 
 */
@Entity
public class EquipeProjet implements Serializable {

	
	private int idEquipeProjet;
	private String intitule;
	private String desciption;

	private PI pi;

	private Set<Enseignant> enseignants;
	private static final long serialVersionUID = 1L;

	public EquipeProjet() {
		super();
		enseignants=new HashSet<Enseignant>();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdEquipeProjet() {
		return this.idEquipeProjet;
	}

	public void setIdEquipeProjet(int idEquipeProjet) {
		this.idEquipeProjet = idEquipeProjet;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	@ManyToOne
	@JoinColumn(name="idPi")
	public PI getPi() {
		return pi;
	}
	public void setPi(PI pi) {
		this.pi = pi;
	}
	
	@OneToMany(mappedBy="equipeProjet")
	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	
	
	



}
