package com.esprit.gestionPI.dao;

import java.util.Set;

import javax.ejb.Remote;

import com.esprit.gestionPI.persistence.Fiche;

@Remote
public interface FicheDaoRemote {
	void add(Fiche e);

	void delete(int id);

	void update(Fiche e);

	Fiche findById(int id);
	
	Set<Fiche> findAll(); 
}
