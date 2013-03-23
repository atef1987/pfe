package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Etudiant;
@Remote
public interface EtudiantDaoRemote {
	void add(Etudiant e);

	void delete(int id);

	void update(Etudiant e);

	Etudiant findById(int id);
	
	Set<Etudiant> findAll(); 
}
