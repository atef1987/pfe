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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((etudiant == null) ? 0 : etudiant.hashCode());
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
		FicheEtudiant other = (FicheEtudiant) obj;
		if (etudiant == null) {
			if (other.etudiant != null)
				return false;
		} else if (!etudiant.equals(other.etudiant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FicheEtudiant [etudiant=" + etudiant + "]";
	}
	
	
   
}
