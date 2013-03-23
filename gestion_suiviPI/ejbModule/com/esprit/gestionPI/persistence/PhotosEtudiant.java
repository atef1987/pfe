package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PhotosEtudiant
 *
 */
@Entity

public class PhotosEtudiant implements Serializable {

	   
	@Id
	private String ID_ET;
	private Blob photosId;
	private static final long serialVersionUID = 1L;

	public PhotosEtudiant() {
		super();
	}   
	public String getID_ET() {
		return this.ID_ET;
	}

	public void setID_ET(String ID_ET) {
		this.ID_ET = ID_ET;
	}   
	public Blob getPhotosId() {
		return this.photosId;
	}

	public void setPhotosId(Blob photosId) {
		this.photosId = photosId;
	}
   
}
