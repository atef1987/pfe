package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Etudiant
 * 
 */
@Entity
public class Etudiant implements Serializable {
	
	private String ID_ET;
	private String nom_ET;
	private String prenom_ET;
	
	private Classe classe;
	
	private Set<FicheEtudiant> fichesEtudiant;
	
	private EquipeEtudiant equipeEtudiant;
	
	private Set<Reponse> reponses;
	

	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
		fichesEtudiant = new HashSet<FicheEtudiant>();
		reponses=new HashSet<Reponse>();

	}

	@Id
	public String getID_ET() {
		return ID_ET;
	}

	public void setID_ET(String iD_ET) {
		ID_ET = iD_ET;
	}

	public String getNom_ET() {
		return nom_ET;
	}

	public void setNom_ET(String nom_ET) {
		this.nom_ET = nom_ET;
	}

	public String getPrenom_ET() {
		return prenom_ET;
	}

	public void setPrenom_ET(String prenom_ET) {
		this.prenom_ET = prenom_ET;
	}

	@ManyToOne
	@JoinColumn(name = "idClasse")
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	@ManyToOne
	@JoinColumn(name="idEuipeEtudiant")
	public EquipeEtudiant getEquipeEtudiant() {
		return equipeEtudiant;
	}

	public void setEquipeEtudiant(EquipeEtudiant equipeEtudiant) {
		this.equipeEtudiant = equipeEtudiant;
	}

	@OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Set<Reponse> reponses) {
		this.reponses = reponses;
	}

	@OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<FicheEtudiant> getFichesEtudiant() {
		return fichesEtudiant;
	}

	public void setFichesEtudiant(Set<FicheEtudiant> fichesEtudiant) {
		this.fichesEtudiant = fichesEtudiant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_ET == null) ? 0 : ID_ET.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result
				+ ((equipeEtudiant == null) ? 0 : equipeEtudiant.hashCode());
		result = prime * result
				+ ((fichesEtudiant == null) ? 0 : fichesEtudiant.hashCode());
		result = prime * result + ((nom_ET == null) ? 0 : nom_ET.hashCode());
		result = prime * result
				+ ((prenom_ET == null) ? 0 : prenom_ET.hashCode());
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
		Etudiant other = (Etudiant) obj;
		if (ID_ET == null) {
			if (other.ID_ET != null)
				return false;
		} else if (!ID_ET.equals(other.ID_ET))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (equipeEtudiant == null) {
			if (other.equipeEtudiant != null)
				return false;
		} else if (!equipeEtudiant.equals(other.equipeEtudiant))
			return false;
		if (fichesEtudiant == null) {
			if (other.fichesEtudiant != null)
				return false;
		} else if (!fichesEtudiant.equals(other.fichesEtudiant))
			return false;
		if (nom_ET == null) {
			if (other.nom_ET != null)
				return false;
		} else if (!nom_ET.equals(other.nom_ET))
			return false;
		if (prenom_ET == null) {
			if (other.prenom_ET != null)
				return false;
		} else if (!prenom_ET.equals(other.prenom_ET))
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
		return "Etudiant [ID_ET=" + ID_ET + ", nom_ET=" + nom_ET
				+ ", prenom_ET=" + prenom_ET + ", classe=" + classe
				+ ", fichesEtudiant=" + fichesEtudiant + ", equipeEtudiant="
				+ equipeEtudiant + ", reponses=" + reponses + "]";
	}
	
	
	
	

}
