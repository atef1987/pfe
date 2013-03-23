package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FicheEtudiant
 *
 */
@Entity
@DiscriminatorValue("ficheEtudiant")
@PrimaryKeyJoinColumn(name="IdFiche",referencedColumnName="IdFiche")

public class FicheEtudiant extends Fiche implements Serializable {
	private Etudiant etudiant;

	
	private static final long serialVersionUID = 1L;

	public FicheEtudiant() {
		super();
	}

	@ManyToOne
	@JoinColumn(name="idEtudiant")
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	
   
}
