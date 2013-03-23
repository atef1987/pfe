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
	
	
	
	
   
}
