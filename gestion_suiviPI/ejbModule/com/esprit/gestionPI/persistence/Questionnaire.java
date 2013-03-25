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

/**
 * Entity implementation class for Entity: Questionnaire
 *
 */
@Entity

public class Questionnaire implements Serializable {

	   
	
	private int idQuestion;
	private String question;
	private Set<Classe> classe;
	private Set<Question> questions;
	private static final long serialVersionUID = 1L;

	public Questionnaire() {
		super();
		classe=new HashSet<Classe>();
		questions=new HashSet<Question>();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@ManyToMany(mappedBy="questionnaires")
	public Set<Classe> getClasse() {
		return classe;
	}

	public void setClasse(Set<Classe> classe) {
		this.classe = classe;
	}

	@OneToMany(mappedBy="questionnaire",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + idQuestion;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((questions == null) ? 0 : questions.hashCode());
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
		Questionnaire other = (Questionnaire) obj;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (idQuestion != other.idQuestion)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questionnaire [idQuestion=" + idQuestion + ", question="
				+ question + ", classe=" + classe + ", questions=" + questions
				+ "]";
	}
	
	
	
	
   
}
