package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.PhotosEtudiant;

@Remote
public interface PhotosEtudiantRemote {
	void add(PhotosEtudiant e);

	void delete(int id);

	void update(PhotosEtudiant e);

	PhotosEtudiant findById(int id);
	
	Set<PhotosEtudiant> findAll();
	

}
