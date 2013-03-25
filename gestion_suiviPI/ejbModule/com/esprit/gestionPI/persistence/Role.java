package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Role
 * 
 */
@Entity
public class Role implements Serializable {

	private int idRole;
	private String intitule;
	private String description;
	private Set<Enseignant> enseignants;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
		enseignants=new HashSet<Enseignant>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
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

	@OneToMany(mappedBy="role")
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((enseignants == null) ? 0 : enseignants.hashCode());
		result = prime * result + idRole;
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
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
		Role other = (Role) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enseignants == null) {
			if (other.enseignants != null)
				return false;
		} else if (!enseignants.equals(other.enseignants))
			return false;
		if (idRole != other.idRole)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", intitule=" + intitule
				+ ", description=" + description + ", enseignants="
				+ enseignants + "]";
	}

	

}
