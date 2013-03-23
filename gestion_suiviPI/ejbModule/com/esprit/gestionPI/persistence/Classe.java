package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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


}
