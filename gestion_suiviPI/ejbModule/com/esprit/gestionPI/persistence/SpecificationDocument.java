package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SpecificationDocument
 *
 */
@Entity

public class SpecificationDocument implements Serializable {

	
	private int id;
	private byte[] data;
	private static final long serialVersionUID = 1L;
   private Projet projet;
   @OneToOne
   @JoinColumn(name="projet_fk")
	public Projet getProjet() {
	return projet;
}
public void setProjet(Projet projet) {
	this.projet = projet;
}
	public SpecificationDocument() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	@Lob
	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
   
}
