package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Fiche
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("fiche")
public class Fiche implements Serializable {

	   
	
	private int IdFiche;

	private Partie partie;
	
	private Enseignant enseignant;
	private ModelFiche modelFiche;
	private static final long serialVersionUID = 1L;

	public Fiche() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdFiche() {
		return this.IdFiche;
	}

	public void setIdFiche(int IdFiche) {
		this.IdFiche = IdFiche;
	}
	@OneToOne(mappedBy="fiche")
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	@ManyToOne
	@JoinColumn(name="idEnseignant")
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	@ManyToOne
	@JoinColumn(name="idModelFiche")
	public ModelFiche getModelFiche() {
		return modelFiche;
	}
	public void setModelFiche(ModelFiche modelFiche) {
		this.modelFiche = modelFiche;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdFiche;
		result = prime * result
				+ ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result
				+ ((modelFiche == null) ? 0 : modelFiche.hashCode());
		result = prime * result + ((partie == null) ? 0 : partie.hashCode());
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
		Fiche other = (Fiche) obj;
		if (IdFiche != other.IdFiche)
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (modelFiche == null) {
			if (other.modelFiche != null)
				return false;
		} else if (!modelFiche.equals(other.modelFiche))
			return false;
		if (partie == null) {
			if (other.partie != null)
				return false;
		} else if (!partie.equals(other.partie))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Fiche [IdFiche=" + IdFiche + ", partie=" + partie
				+ ", enseignant=" + enseignant + ", modelFiche=" + modelFiche
				+ "]";
	}
	
	
	
	
	
	
   
}
