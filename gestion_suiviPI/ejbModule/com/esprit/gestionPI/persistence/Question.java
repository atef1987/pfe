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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {

	
	private int idQuestion;
	private String description;
	private Set<Reponse> reponses;
	private Questionnaire questionnaire;
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
		reponses=new HashSet<Reponse>();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(Set<Reponse> reponses) {
		this.reponses = reponses;
	}
	
	@ManyToOne
	@JoinColumn(name="idQuestionnaire")
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idQuestion;
		result = prime * result
				+ ((questionnaire == null) ? 0 : questionnaire.hashCode());
		result = prime * result
				+ ((reponses == null) ? 0 : reponses.hashCode());
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
		Question other = (Question) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idQuestion != other.idQuestion)
			return false;
		if (questionnaire == null) {
			if (other.questionnaire != null)
				return false;
		} else if (!questionnaire.equals(other.questionnaire))
			return false;
		if (reponses == null) {
			if (other.reponses != null)
				return false;
		} else if (!reponses.equals(other.reponses))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", description="
				+ description + ", reponses=" + reponses + ", questionnaire="
				+ questionnaire + "]";
	}
	
	
   
}
