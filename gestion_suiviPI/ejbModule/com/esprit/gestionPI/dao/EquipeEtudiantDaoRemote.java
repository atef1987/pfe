package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.EquipeEtudiant;
@Remote
public interface EquipeEtudiantDaoRemote {
	void add(EquipeEtudiant e);

	void delete(int id);

	void update(EquipeEtudiant e);

	EquipeEtudiant findById(int id);
	
	Set<EquipeEtudiant> findAll(); 
}
