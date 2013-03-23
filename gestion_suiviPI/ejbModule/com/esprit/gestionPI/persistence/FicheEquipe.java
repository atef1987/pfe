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
	
	
   
}
