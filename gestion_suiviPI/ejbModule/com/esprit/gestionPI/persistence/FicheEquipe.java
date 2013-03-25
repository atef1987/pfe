package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FicheEquipe
 *
 */
@Entity
@DiscriminatorValue("ficheEquipe")
@PrimaryKeyJoinColumn(name="IdFiche",referencedColumnName="IdFiche")

public class FicheEquipe extends Fiche implements Serializable {

	
	private int travailRealiser;
	private int travailNonRealiser;
	private float note;
	
	private FicheEquipe ficheEquipe;
	private static final long serialVersionUID = 1L;

	public FicheEquipe() {
		super();
	}   
	public int getTravailRealiser() {
		return this.travailRealiser;
	}

	public void setTravailRealiser(int travailRealiser) {
		this.travailRealiser = travailRealiser;
	}   
	public int getTravailNonRealiser() {
		return this.travailNonRealiser;
	}

	public void setTravailNonRealiser(int travailNonRealiser) {
		this.travailNonRealiser = travailNonRealiser;
	}   
	public float getNote() {
		return this.note;
	}

	public void setNote(float note) {
		this.note = note;
	}
	
	@ManyToOne
	@JoinColumn(name="idEquipeEtudiant")
	public FicheEquipe getFicheEquipe() {
		return ficheEquipe;
	}
	public void setFicheEquipe(FicheEquipe ficheEquipe) {
		this.ficheEquipe = ficheEquipe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((ficheEquipe == null) ? 0 : ficheEquipe.hashCode());
		result = prime * result + Float.floatToIntBits(note);
		result = prime * result + travailNonRealiser;
		result = prime * result + travailRealiser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FicheEquipe other = (FicheEquipe) obj;
		if (ficheEquipe == null) {
			if (other.ficheEquipe != null)
				return false;
		} else if (!ficheEquipe.equals(other.ficheEquipe))
			return false;
		if (Float.floatToIntBits(note) != Float.floatToIntBits(other.note))
			return false;
		if (travailNonRealiser != other.travailNonRealiser)
			return false;
		if (travailRealiser != other.travailRealiser)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FicheEquipe [travailRealiser=" + travailRealiser
				+ ", travailNonRealiser=" + travailNonRealiser + ", note="
				+ note + ", ficheEquipe=" + ficheEquipe + "]";
	}
	
	
   
}
