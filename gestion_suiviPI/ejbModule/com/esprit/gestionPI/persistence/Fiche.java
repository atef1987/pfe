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
	
	
	
	
	
	
   
}
