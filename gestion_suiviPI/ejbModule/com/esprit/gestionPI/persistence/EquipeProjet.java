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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((desciption == null) ? 0 : desciption.hashCode());
		result = prime * result
				+ ((enseignants == null) ? 0 : enseignants.hashCode());
		result = prime * result + idEquipeProjet;
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((pi == null) ? 0 : pi.hashCode());
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
		EquipeProjet other = (EquipeProjet) obj;
		if (desciption == null) {
			if (other.desciption != null)
				return false;
		} else if (!desciption.equals(other.desciption))
			return false;
		if (enseignants == null) {
			if (other.enseignants != null)
				return false;
		} else if (!enseignants.equals(other.enseignants))
			return false;
		if (idEquipeProjet != other.idEquipeProjet)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (pi == null) {
			if (other.pi != null)
				return false;
		} else if (!pi.equals(other.pi))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EquipeProjet [idEquipeProjet=" + idEquipeProjet + ", intitule="
				+ intitule + ", desciption=" + desciption + ", pi=" + pi
				+ ", enseignants=" + enseignants + "]";
	}
	
	
	
	



}
