package com.esprit.gestionPI.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PI
 *
 */
@Entity

public class PI implements Serializable {

	   
	
	private int idPI;
	private String intitule;
	private String description;
	private static final long serialVersionUID = 1L;

	public PI() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPI() {
		return this.idPI;
	}

	public void setIdPI(int idPI) {
		this.idPI = idPI;
	}   
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idPI;
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
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
		PI other = (PI) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idPI != other.idPI)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PI [idPI=" + idPI + ", intitule=" + intitule + ", description="
				+ description + "]";
	}
   
}
