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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((criteres == null) ? 0 : criteres.hashCode());
		result = prime * result + idModelFiche;
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
		ModelFiche other = (ModelFiche) obj;
		if (criteres == null) {
			if (other.criteres != null)
				return false;
		} else if (!criteres.equals(other.criteres))
			return false;
		if (idModelFiche != other.idModelFiche)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ModelFiche [idModelFiche=" + idModelFiche + ", criteres="
				+ criteres + "]";
	}
	
	
   
}
