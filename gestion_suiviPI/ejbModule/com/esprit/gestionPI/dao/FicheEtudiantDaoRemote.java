package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.FicheEtudiant;

@Remote
public interface FicheEtudiantDaoRemote {
	void add(FicheEtudiant e);

	void delete(int id);

	void update(FicheEtudiant e);

	FicheEtudiant findById(int id);
	
	Set<FicheEtudiant> findAll(); 
}
