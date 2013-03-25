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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID_ET == null) ? 0 : ID_ET.hashCode());
		result = prime * result
				+ ((photosId == null) ? 0 : photosId.hashCode());
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
		PhotosEtudiant other = (PhotosEtudiant) obj;
		if (ID_ET == null) {
			if (other.ID_ET != null)
				return false;
		} else if (!ID_ET.equals(other.ID_ET))
			return false;
		if (photosId == null) {
			if (other.photosId != null)
				return false;
		} else if (!photosId.equals(other.photosId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PhotosEtudiant [ID_ET=" + ID_ET + ", photosId=" + photosId
				+ "]";
	}
   
}
