package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Photo
 *
 */
@Entity
@Table(name="photo")

public class Photo implements Serializable {

	
	private int id;
	private byte[] data;
	
	private Projet projet;
	private static final long serialVersionUID = 1L;

	public Photo() {
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
	@OneToOne
	@JoinColumn(name="projet_fk")
	public Projet getProjet() {
		return projet;
	}
	
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
   
}
