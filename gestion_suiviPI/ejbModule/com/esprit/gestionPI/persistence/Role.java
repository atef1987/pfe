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

	

}
