package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Classe implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code_cl;
	private String intitule;
	private String description;
	private String filiere;
	private Set<Etudiant> etudiants;
	public Classe() {
		super();
		etudiants=new HashSet<Etudiant>();
		questionnaires=new HashSet<Questionnaire>();
	} 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCode_cl() {
		return code_cl;
	}
	public void setCode_cl(int code_cl) {
		this.code_cl = code_cl;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	@OneToMany(mappedBy="classe",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@ManyToMany
	public Set<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}
	public void setQuestionnaires(Set<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	private Set<Questionnaire> questionnaires;
	@Override
	public String toString() {
		return "Classe [code_cl=" + code_cl + ", intitule=" + intitule
				+ ", description=" + description + ", filiere=" + filiere
				+ ", etudiants=" + etudiants + ", questionnaires="
				+ questionnaires + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code_cl;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((etudiants == null) ? 0 : etudiants.hashCode());
		result = prime * result + ((filiere == null) ? 0 : filiere.hashCode());
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result
				+ ((questionnaires == null) ? 0 : questionnaires.hashCode());
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
		Classe other = (Classe) obj;
		if (code_cl != other.code_cl)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (etudiants == null) {
			if (other.etudiants != null)
				return false;
		} else if (!etudiants.equals(other.etudiants))
			return false;
		if (filiere == null) {
			if (other.filiere != null)
				return false;
		} else if (!filiere.equals(other.filiere))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (questionnaires == null) {
			if (other.questionnaires != null)
				return false;
		} else if (!questionnaires.equals(other.questionnaires))
			return false;
		return true;
	}

}
