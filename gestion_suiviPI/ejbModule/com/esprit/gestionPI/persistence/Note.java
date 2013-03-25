package com.esprit.gestionPI.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Note
 * 
 */
@Entity
@IdClass(NotePK.class)
public class Note implements Serializable {


	private int idFiche;

	private int idCritere;
	private float noteAssocier;
	
	private Fiche fiche;
	
	private Critere critere;
	private static final long serialVersionUID = 1L;

	public Note() {
		super();
	}

	@Id
	public int getIdFiche() {
		return this.idFiche;
	}

	public void setIdFiche(int idFicheEtudiant) {
		this.idFiche = idFicheEtudiant;
	}

	@Id
	public int getIdCritere() {
		return this.idCritere;
	}

	public void setIdCritere(int idCritere) {
		this.idCritere = idCritere;
	}

	public float getNoteAssocier() {
		return this.noteAssocier;
	}

	public void setNoteAssocier(float noteAssocier) {
		this.noteAssocier = noteAssocier;
	}

	@ManyToOne
	@JoinColumn(name = "idFiche", referencedColumnName = "IdFiche",updatable=false,insertable=false)
	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	@ManyToOne
	@JoinColumn(name = "idCritere", referencedColumnName = "idCritere",updatable=false,insertable=false)
	public Critere getCritere() {
		return critere;
	}

	public void setCritere(Critere critere) {
		this.critere = critere;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((critere == null) ? 0 : critere.hashCode());
		result = prime * result + ((fiche == null) ? 0 : fiche.hashCode());
		result = prime * result + idCritere;
		result = prime * result + idFiche;
		result = prime * result + Float.floatToIntBits(noteAssocier);
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
		Note other = (Note) obj;
		if (critere == null) {
			if (other.critere != null)
				return false;
		} else if (!critere.equals(other.critere))
			return false;
		if (fiche == null) {
			if (other.fiche != null)
				return false;
		} else if (!fiche.equals(other.fiche))
			return false;
		if (idCritere != other.idCritere)
			return false;
		if (idFiche != other.idFiche)
			return false;
		if (Float.floatToIntBits(noteAssocier) != Float
				.floatToIntBits(other.noteAssocier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [idFiche=" + idFiche + ", idCritere=" + idCritere
				+ ", noteAssocier=" + noteAssocier + ", fiche=" + fiche
				+ ", critere=" + critere + "]";
	}

}
