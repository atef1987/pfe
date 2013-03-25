package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reponse
 *
 */
@Entity

public class Reponse implements Serializable {

	   
	
	private int idReponse;
	private String description;
	private Etudiant etudiant;
	private Question question;
	private static final long serialVersionUID = 1L;

	public Reponse() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdReponse() {
		return this.idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="idEtudiant")
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@ManyToOne
	@JoinColumn(name="idQuestion")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((etudiant == null) ? 0 : etudiant.hashCode());
		result = prime * result + idReponse;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
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
		Reponse other = (Reponse) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		if (idReponse != other.idReponse)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reponse [idReponse=" + idReponse + ", description="
				+ description + ", etudiant=" + etudiant + ", question="
				+ question + "]";
	}
	
	
   
}
