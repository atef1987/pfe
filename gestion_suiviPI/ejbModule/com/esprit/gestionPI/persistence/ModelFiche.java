package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: ModelFiche
 *
 */
@Entity

public class ModelFiche implements Serializable {

	
	private int idModelFiche;
	private Set<Critere> criteres;
	private static final long serialVersionUID = 1L;

	public ModelFiche() {
		super();
		criteres=new HashSet<Critere>();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdModelFiche() {
		return this.idModelFiche;
	}

	public void setIdModelFiche(int idModelFiche) {
		this.idModelFiche = idModelFiche;
	}
	@ManyToMany
	public Set<Critere> getCriteres() {
		return criteres;
	}
	public void setCriteres(Set<Critere> criteres) {
		this.criteres = criteres;
	}
	
	
   
}
